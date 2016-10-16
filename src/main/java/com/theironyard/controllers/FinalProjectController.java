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
            User user1 = new User();
            User user2 = new User();

            user.setName("Dr. Barringer");
            user1.setName("Dr. Toboggan");
            user2.setName("Dr. Sanchez");

            users.save(user);
            users.save(user1);
            users.save(user2);


            Patient patient = new Patient();
            Patient patient1 = new Patient();
            Patient patient2 = new Patient();
            Patient patient3 = new Patient();
            Patient patient4 = new Patient();
            Patient patient5 = new Patient();
            Patient patient6 = new Patient();
            Patient patient7 = new Patient();
            Patient patient8 = new Patient();
            Patient patient9 = new Patient();
            Patient patient10 = new Patient();

            patient.setFirstName("Jeb");
            patient.setLastName("Gladice");
            patient1.setFirstName("Allejandro");
            patient1.setLastName("Rodriguez");
            patient2.setFirstName("Sandra");
            patient2.setLastName("Dee");
            patient3.setFirstName("Sammy");
            patient3.setLastName("Smith");
            patient4.setFirstName("Thomas");
            patient4.setLastName("Edison");
            patient5.setFirstName("Bill");
            patient5.setLastName("Gates");
            patient6.setFirstName("Barack");
            patient6.setLastName("Obama");
            patient7.setFirstName("Lloyd");
            patient7.setLastName("Christmas");
            patient8.setFirstName("Chip");
            patient8.setLastName("Jolly");
            patient9.setFirstName("Suzie");
            patient9.setLastName("Que");
            patient10.setFirstName("David");
            patient10.setLastName("Lee");

            Form form1 = new Form();
            Form form2 = new Form();
            Form form3 = new Form();
            Form form4 = new Form();



            form1.setTitle("Oswestry Disability Questionnaire\n");
            form2.setTitle("Neck Pain Disability Index\n");
            form3.setTitle("The Patient-Specific Functional Scale\n");
            form4.setTitle("PFDI-20\n");


            form1.setName("testName\n");

            form1.setDescription("This questionnaire has been designed to give us information as to how your back or leg pain is affecting your ability to manage in everyday life. Please answer by checking the scale for the level which best applies to you. \n");


            Question question = new Question();
            Question question1 = new Question();
            Question question2 = new Question();
            Question question3 = new Question();
            Question question4 = new Question();



            question.setText("Pain intensity\n");
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




            ArrayList<Question> questionGroup1 = new ArrayList<Question>();
            questionGroup1.add(question);
            questionGroup1.add(question1);
            questionGroup1.add(question2);
            questionGroup1.add(question3);
            questionGroup1.add(question4);



//NEW QUESTION LIST
            Question question5 = new Question();
            Question question6 = new Question();
            Question question7 = new Question();
            Question question8 = new Question();
            Question question9 = new Question();
            Question question10 = new Question();

            question5.setText("Personal Care (Washing, Dressing, etc.)");
            question5.setAnswer("0(I can look after myself normally without causing extra pain)\n" +
                    "5(I need some help but manage most of my personal care)\n" +
                    "10(i do not get dressed, I wash with difficulty and stay in bed)\n");

            question6.setText("Reading");
            question6.setAnswer("0(I can read as much as I want to with no pain in my neck)\n" +
                    "5(I can’t read as much as I want because of moderate pain in my neck)\n" +
                    "10(I cannot read at all) \n");

            question7.setText("Headaches\n");
            question7.setAnswer("0(I have no headaches at all)\n" +
                    "5(I have moderate headaches, which come frequently)\n" +
                    "10(I have headaches almost all of the time)\n");

            question8.setText("Work\n");
            question8.setAnswer("0(I can do as much work as I want to)\n" +
                    "5(I cannot do my usual work)\n" +
                    "10(I can’t do any work at all)\n");

            question9.setText("Concentration\n");
            question9.setAnswer("0(I can concentrate fully when I wast to with no difficulty)\n" +
                    "5(I have a fair degree of difficulty in concentrating when I want to)\n" +
                    "10(I cannot concentrate at all)\n");

            question10.setText("Driving\n");
            question10.setAnswer("0(I can drive my car without any neck pain)\n" +
                    "5(I can’t drive my car as long as I want because of slight pain in my neck)\n" +
                    "10(I can’t drive my car at all because of the pain)\n");


            questions.save(question5);
            questions.save(question6);
            questions.save(question7);
            questions.save(question8);
            questions.save(question9);
            questions.save(question10);


            ArrayList<Question> questionGroup2 = new ArrayList<Question>();
            questionGroup1.add(question5);
            questionGroup1.add(question6);
            questionGroup1.add(question7);
            questionGroup1.add(question8);
            questionGroup1.add(question9);
            questionGroup1.add(question10);

            form1.setQuestions(questionGroup1);
            form2.setQuestions(questionGroup2);




//            try {
//                user.setPassword(PasswordStorage.createHash("hunter2"));
//            } catch (PasswordStorage.CannotPerformOperationException e) {
//                e.printStackTrace();
//            }



            forms.save(form1);
            forms.save(form2);

            patients.save(patient);
            patients.save(patient1);
            patients.save(patient2);
            patients.save(patient3);
            patients.save(patient4);
            patients.save(patient5);
            patients.save(patient6);
            patients.save(patient7);
            patients.save(patient8);
            patients.save(patient9);
            patients.save(patient10);


//QUESTION ABOUT ADDING PATIENTS BY DOCTOR RATHER THAN ALL PATIENTS FOR ALL DOCS

            user1.getPatients().add(patient);
//            user1.getPatients().add(patient1);
//            user1.getPatients().add(patient2);
//            user1.getPatients().add(patient3);
//            user2.getPatients().add(patient4);
//            user2.getPatients().add(patient5);
//            user2.getPatients().add(patient6);
//            user2.getPatients().add(patient7);
//            user.getPatients().add(patient8);
//            user.getPatients().add(patient9);
//            user.getPatients().add(patient10);


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




    @RequestMapping(path = "/patients", method = RequestMethod.GET)
    public List<Patient> patients() {

        return (List) patients.findAll();
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
