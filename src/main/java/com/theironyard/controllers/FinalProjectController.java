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

            form.setTitle("Oswestry Disability Questionnaire\n");
            form.setName("testName\n");
            form.setDescription("This questionnaire has been designed to give us information as to how your back or leg pain is affecting your ability to manage in everyday life. Please answer by checking the scale for the level which best applies to you. \n");

            Question question = new Question();
            Question question1 = new Question();
            Question question2 = new Question();
            Question question3 = new Question();
            Question question4 = new Question();

            question.setText("Pain Intensity\n");
            question.setAnswer("0(I have no pain at the moment) \n" +
                    "5(The pain is fairly severe at the moment)\n" +
                    "10(The pain is the worst imaginable at the moment)\n");
            questions.save(question);

            question1.setText("Lifting\n");
            question1.setAnswer("0(I can lift heavy weights without extra pain)\n" +
                    "5(Pain prevents me lifting heavy weights but I can manage light to medium weights if they are conveniently positioned)\n" +
                    "10(I cannot lift or carry anything)\n");
            questions.save(question1);

            question2.setText("Walking\n");
            question2.setAnswer("0(Pain does not prevent me walking any distance)\n" +
                    "5(Pain prevents me from walking more than 500 metres)\n" +
                    "10(I am in bed most of the time)\n");
            questions.save(question2);

            question3.setText("Sitting\n");
            question3.setAnswer("0(I can sit in any chair as long as I like)\n" +
                    "5(Pain prevents me from sitting more than 30 mintutes)\n" +
                    "10(Pain prevents me from sitting at all)\n");
            questions.save(question3);

            question4.setText("Sleeping\n");
            question4.setAnswer("0(My sleep is never disturbed by pain)\n" +
                    "5(Pain prevents me from standing for more than 30 minutes)\n" +
                    "10(Pain prevents me from standing at all)\n");
            questions.save(question4);

            ArrayList<Question> current = new ArrayList<Question>();
            current.add(question);
            current.add(question1);
            current.add(question2);
            current.add(question3);
            current.add(question4);

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
