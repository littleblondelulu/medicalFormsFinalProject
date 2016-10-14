package com.theironyard.controllers;

import com.theironyard.entities.*;
import com.theironyard.services.*;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//need to change all -- return "/"

@RestController
public class FinalProjectController {

    @Autowired
    UserRepository users;

    @Autowired
    FormRepository forms;

    @Autowired
    PatientRepository patients;

    @Autowired
    AnswerRepository answers;

    @Autowired
    QuestionRepository questions;

    @Autowired
    RecordRepository records;






//add a few users
    //tie up some patients with those users

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.setName("Zach");
            users.save(user);

            Patient patient = new Patient();
            patient.setFirstName("Dee");

            Form form = new Form();

            form.setTitle("testTitle");
            form.setName("testName");
            form.setDescription("testDescription: adfhadskljfhdskjfhdjksh hadflkhjfslksdhfklj ahlkdjfdskjl");

            Question question = new Question();
            Question question1 = new Question();

            question.setText("What's your pain level today?");
            question.setAnswer("not bad");
            questions.save(question);

            question1.setText("DFKHJAFH;D;S?");
            question1.setAnswer("fhajklhjk");
            questions.save(question1);

            ArrayList<Question> current = new ArrayList<Question>();
            current.add(question);
            current.add(question1);

            form.setQuestions(current);
//            try {
//                user.setPassword(PasswordStorage.createHash("hunter2"));
//            } catch (PasswordStorage.CannotPerformOperationException e) {
//                e.printStackTrace();
//            }

            forms.save(form);
            patients.save(patient);



            user.getPatients().add(patient);
            users.save(user);

        }
    }






    //Need to change this to standard login -- no pw protection

    //pw protected login
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(String username, String password, HttpSession session, HttpServletResponse response) throws Exception {
        User user = users.findFirstByName(username);
        if (user == null) {
            user = new User(username, PasswordStorage.createHash(password));
            users.save(user);
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Wrong password");
        }
        session.setAttribute("username", username);
        response.sendRedirect("/");
        return user;
    }

    //no concept of logging in really -- so don't need a logout







    //ROUTE TO USER IN DATABASE AND SEND TO FRONT END
    //ASSIGN SESSION
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User u = users.findOne(id);

        return u;
    }









    // GET     /patients --- TELL Aaron to change endpt to this
    //get /patients
    @RequestMapping(path = "/user/{userId}/patients", method = RequestMethod.GET)
    public List<Patient> allPatient(@PathVariable int userId) {
        User u = users.findOne(userId);

        return u.getPatients();
    }

//
//    Return summary of all the patients.
//
//    Format:
//
//            [{
//        firstName: "string",
//                lastName: "string",
//                id: number }]








    @RequestMapping(path = "/patients/{patientId}", method = RequestMethod.GET)
    public Patient patient(Integer patientId) {
        return patients.findById(patientId);
    }









    @RequestMapping(path = "/forms", method = RequestMethod.GET)
    public List<Form> forms() {

        return (List) forms.findAll();
    }

//    Format:
//            [{
//        id: number,
//                title: "string",
//                description: "string",
//    }]






    //getting a new form here
    //get one form
    //Returns a specific form and associates it with a patient
    @RequestMapping(path = "/forms/{formId}/{patientId}", method = RequestMethod.GET)
    public FormPatientViewModel form(Integer formId, Integer patientId) {
        Form form = forms.findById(formId);
        Patient patient = patients.findById(patientId);
        //set formPatientView to form and patient
        FormPatientViewModel fPVM = new FormPatientViewModel(form, patient);
        //return formPatientView class
        return fPVM;
    }


//    Format:
//            [{
//        id: number,
//                name: "string",
//                date: number,
//                patient: {
//            firstName: "string",
//                    lastName: "string",
//        },
//        questions: [
//        {
//            id: number,
//                    title: "string",
//                type: "string",
//                text: "string",
//        }
//    ]
//    }]








    //post /addResponses
    //POST    /records/{formId}/{patientId}
    // Submit answers for {formId} filled in by {patientId}.
    @RequestMapping(path = "/records/{formId}/{patientId}", method = RequestMethod.POST)
    public void records(List<Answer> answers, Integer patientId) {
        Patient p = patients.findById(patientId);
        Record record = new Record(answers);
        p.getRecords().add(record);
        //will need to use a view model class here as well????
    }

//    Format:
//
//            [{
//        id: number,
//                questions: [
//        {
//            id: number,
//                    answer: string,
//        }
//    ]
//    }]








    //Returns summary of all the records per form.
    @RequestMapping(path = "user/{userId}/records", method = RequestMethod.GET)
    public String recordSummary(/*will probably need to take in a view model class*/) {
        //need to add code here for the view model class
        return "";
    }

//         Format:
//
//                                          [{
//        id: number,
//                name: string,
//                date: "number",
//                patient: {
//            firstName: "string",
//                    lastName: "string",
//        }
//    }]









    //Returns a specific record (form with answers).
    @RequestMapping(path = "/record/{recordId}", method = RequestMethod.GET)
    public Record recordAnswers(Integer id){
        Record record = records.findById(id);

        return record;
    }


//    Format:
//            [{
//
}

//what data would be specific to these endpts?
//FormPatientViewModel
//new FormPatientViewModel(forms.findById(formId), patients.findById(patientId));
