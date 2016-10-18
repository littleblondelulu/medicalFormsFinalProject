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



    @PostConstruct
    public void init() {

        if (users.count() == 0) {
            User user = new User();
            user.setName("Dr. Barringer");

            User user1 = new User();
            user1.setName("Dr. Tobaggon");

            User user2 = new User();
            user2.setName("Dr. Sanchez");







            Patient patient = new Patient();
            patient.setFirstName("Jeb");
            patient.setLastName("Gladys");
            patients.save(patient);

            Patient patient1 = new Patient();
            patient1.setFirstName("Alex");
            patient1.setLastName("Rodriguez");
            patients.save(patient1);

            Patient patient2 = new Patient();
            patient2.setFirstName("Bill");
            patient2.setLastName("Gates");
            patients.save(patient2);

            Patient patient3 = new Patient();
            patient3.setFirstName("Melinda");
            patient3.setLastName("Gates");
            patients.save(patient3);

            Patient patient4 = new Patient();
            patient4.setFirstName("Layla");
            patient4.setLastName("Mahoney");
            patients.save(patient4);

            Patient patient5 = new Patient();
            patient5.setFirstName("Jimmy");
            patient5.setLastName("Smith");
            patients.save(patient5);




            Patient patient6 = new Patient();
            patient6.setFirstName("Ron");
            patient6.setLastName("Burgundy");
            patients.save(patient6);

            Patient patient7 = new Patient();
            patient7.setFirstName("Tom");
            patient7.setLastName("Seleck");
            patients.save(patient7);

            Patient patient8 = new Patient();
            patient8.setFirstName("Steve");
            patient8.setLastName("Jobs");
            patients.save(patient8);




            Patient patient9 = new Patient();
            patient9.setFirstName("Belinda");
            patient9.setLastName("Carlisle");
            patients.save(patient9);

            Patient patient10 = new Patient();
            patient10.setFirstName("Jones");
            patient10.setLastName("McGee");
            patients.save(patient10);

            Patient patient11 = new Patient();
            patient11.setFirstName("Ann");
            patient11.setLastName("Sailor");
            patients.save(patient11);

            Patient patient12 = new Patient();
            patient12.setFirstName("Libby");
            patient12.setLastName("Van Vurren");
            patients.save(patient12);

            Patient patient13 = new Patient();
            patient13.setFirstName("Mike");
            patient13.setLastName("Peddigrew");
            patients.save(patient13);








            ArrayList<Patient> patientsGroup1 = new ArrayList<Patient>();
            ArrayList<Patient> patientsGroup2 = new ArrayList<Patient>();
            ArrayList<Patient> patientsGroup3 = new ArrayList<Patient>();


            patientsGroup1.add(patient);
            patientsGroup1.add(patient1);
            patientsGroup1.add(patient2);
            patientsGroup1.add(patient3);
            patientsGroup1.add(patient4);
            patientsGroup1.add(patient5);

            patientsGroup2.add(patient6);
            patientsGroup2.add(patient7);
            patientsGroup2.add(patient8);

            patientsGroup3.add(patient9);
            patientsGroup3.add(patient10);
            patientsGroup3.add(patient11);
            patientsGroup3.add(patient12);
            patientsGroup3.add(patient13);

            user.setPatients(patientsGroup1);
            user1.setPatients(patientsGroup2);
            user2.setPatients(patientsGroup3);


            users.save(user);
            users.save(user1);
            users.save(user2);








            Form form1 = new Form();

            form1.setTitle("Oswestry Disability Questionnaire\n");
            form1.setName("Oswestry Disability Questionnaire\n");
            form1.setDescription("This questionnaire has been designed to give us information as to how your back or leg pain is affecting your ability to manage in everyday life. Please answer by checking the scale for the level which best applies to you.");


            Form form2 = new Form();

            form2.setTitle("Neck Pain Disability Index");
            form2.setName("Neck Pain Disability Index");
            form2.setDescription("This questionnaire has been designed to give the doctor information as to how your neck pain has affected your ability to manage in everyday life. Please mark the ONE NUMBER in each question, which most closely describes your problem. We realize you may consider that two of the statements in any one section relate to you, but only mark the box which most closely describes your problem");

            Form form3 = new Form();

            form3.setTitle("The Patient-Specific Functional Scale");
            form3.setName("The Patient-Specific Functional Scale");
            form3.setDescription("I am going to ask you to identify up to three important activities that you are unable to do or are having difficulty\n" +
                    "with as a result of your _________________ problem.");

            Form form4 = new Form();

        form4.setTitle("PFDI-20");
        form4.setName("PFDI-20");
        form4.setDescription("Please answer all the questions in the following survey. These questions\n" +
                "will ask you if you have certain bladder, pelvic, or bowel symptoms and,\n" +
                "if you do, how much they bother you. Answer these questions by choosing the\n" +
                "appropriate number. While answering these questions, please consider your\n" +
                "symptoms over the last 3 months. All items use the following format with\n" +
                "a response scale from 1-10.");


            Question question = new Question();
            Question question1 = new Question();
            Question question2 = new Question();
            Question question3 = new Question();
            Question question4 = new Question();

        Question question5 = new Question();
        Question question6 = new Question();
        Question question7 = new Question();
        Question question8 = new Question();
        Question question9 = new Question();
        Question question10 = new Question();

        Question question11 = new Question();
        Question question12 = new Question();
        Question question13 = new Question();
        Question question14 = new Question();
        Question question15 = new Question();


        Question question16 = new Question();
        Question question17 = new Question();
        Question question18 = new Question();
        Question question19 = new Question();



        question.setTitle("Pain intensity\n");
            question.setText("0(I have no pain at the moment) \n" +
                    "5(The pain is fairly severe at the moment)\n" +
                    "10(The pain is the worst imaginable at the moment)\n");
            question.setAnswer("");
            question.setType("scale1-10");
            questions.save(question);



            question1.setTitle("Lifting\n");
            question1.setText("0(I can lift heavy weights without extra pain)\n" +
                    "5(Pain prevents me lifting heavy weights but I can manage light to medium weights if they are conveniently positioned)\n" +
                    "10(I cannot lift or carry anything)\n");
            question1.setAnswer("");
            question1.setType("scale1-10");
            questions.save(question1);



            question2.setTitle("Walking\n");
            question2.setText("0(Pain does not prevent me walking any distance)\n" +
                    "5(Pain prevents me from walking more than 500 metres)\n" +
                    "10(I am in bed most of the time)\n");
            question2.setAnswer("");
            question2.setType("scale1-10");
            questions.save(question2);



            question3.setTitle("Sitting\n");
            question3.setText("0(I can sit in any chair as long as I like)\n" +
                    "5(Pain prevents me from sitting more than 30 mintutes)\n" +
                    "10(Pain prevents me from sitting at all)\n");
            question3.setAnswer("");
            question3.setType("scale1-10");
            questions.save(question3);



            question4.setTitle("Sleeping\n");
            question4.setText("0(My sleep is never disturbed by pain)\n" +
                    "5(Pain prevents me from standing for more than 30 minutes)\n" +
                    "10(Pain prevents me from standing at all)\n");
            question4.setAnswer("");
            question4.setType("scale1-10");
            questions.save(question4);







        question5.setTitle("Personal Care (Washing, Dressing, etc");
        question5.setText("0(I can look after myself normally without causing extra pain)\n" + "5(I need some help but manage most of my personal care)\n" + "10(i do not get dressed, I wash with difficulty and stay in bed)\n)");
        question5.setAnswer("");
        question5.setType("scale1-10");
        questions.save(question5);

        question6.setTitle("Reading");
        question6.setText("0(I can read as much as I want to with no pain in my neck)\n" + "5(I can’t read as much as I want because of moderate pain in my neck)\n" + "10(I cannot read at all) \n");
        question6.setAnswer("");
        question6.setType("scale1-10");
        questions.save(question6);

        question7.setTitle("Headaches");
        question7.setText("0(I have no headaches at all)\n" +  "5(I have moderate headaches, which come frequently)\n" + "10(I have headaches almost all of the time)");
        question7.setAnswer("");
        question7.setType("scale1-10");
        questions.save(question7);

        question8.setTitle("Work");
        question8.setText("0(I can do as much work as I want to)\n" + "5(I cannot do my usual work)\n " + "10(I can’t do any work at all)");
        question8.setAnswer("");
        question8.setType("scale1-10");
        questions.save(question8);

        question9.setTitle("Concentration");
        question9.setText("0(I can concentrate fully when I wast to with no difficulty)\n" + "5(I have a fair degree of difficulty in concentrating when I want to)\n" + "10(I cannot concentrate at all)\n");
        question9.setAnswer("");
        question9.setType("scale1-10");
        questions.save(question9);

        question10.setTitle("Driving");
        question10.setText("0(I can drive my car without any neck pain)\n" + "5(I can’t drive my car as long as I want because of slight pain in my neck)\n" + "10(I can’t drive my car at all because of the pain)\n");
        question10.setAnswer("");
        question10.setType("scale1-10");
        questions.save(question10);






        question11.setTitle("Initial Assessment");
        question11.setText("Today, are there any activities that you are unable to do\n" +
                "or having difficulty with because of your _________________ problem?\n");
        question11.setAnswer("");
        question11.setType("fillIn");
        questions.save(question11);

        question12.setTitle("Activities");
        question12.setText("Please name a specific activity that causes you pain. _______________");
        question12.setAnswer("");
        question12.setType("fillIn");
        questions.save(question12);

        question13.setTitle("Activities");
        question13.setText("Please rate your pain during this activity on the scale below.");
        question13.setAnswer("");
        question13.setType("scale1-10");
        questions.save(question13);

        question14.setTitle("Activities");
        question14.setText("Please name a specific activity that causes you pain. _______________");
        question14.setAnswer("");
        question14.setType("fillIn");
        questions.save(question14);

        question15.setTitle("Activities");
        question15.setText("Please rate your pain during this activity on the scale below.");
        question15.setAnswer("");
        question15.setType("scale1-10");
        questions.save(question15);





        question16.setTitle("Pelvic Organ Prolapse Distress Inventory 6 (POPDI-6)");
        question16.setText("On a scale of 1-10, do you usually experience pressure in the lower abdomen?");
        question16.setAnswer("");
        question16.setType("scale1-10");
        questions.save(question16);

        question17.setTitle("Colorectal-Anal Distress Inventory 9 (CRAD-8)");
        question17.setText("On a scale of 1-10, do you feel you need to strain too hard to have a bowel movement?");
        question17.setAnswer("");
        question17.setType("scale1-10");
        questions.save(question17);

        question18.setTitle("Urinary Distress Inventory 6 (UDI-6)");
        question18.setText("On a scale of 1-10, do you experience frequent urination?");
        question18.setAnswer("");
        question18.setType("scale1-10");
        questions.save(question18);

        question19.setTitle("Urinary Distress Inventory 6 (UDI-6)");
        question19.setText("On a scale of 1-10, do you usually experience difficulty emptying your bladder?");
        question19.setAnswer("");
        question19.setType("scale1-10");
        questions.save(question19);



        ArrayList<Question> questionGroup1 = new ArrayList<Question>();
            questionGroup1.add(question);
            questionGroup1.add(question1);
            questionGroup1.add(question2);
            questionGroup1.add(question3);
            questionGroup1.add(question4);


        ArrayList<Question> questionGroup2 = new ArrayList<Question>();
        questionGroup2.add(question5);
        questionGroup2.add(question6);
        questionGroup2.add(question7);
        questionGroup2.add(question8);
        questionGroup2.add(question9);
        questionGroup2.add(question10);

        ArrayList<Question> questionGroup3 = new ArrayList<Question>();
        questionGroup3.add(question11);
        questionGroup3.add(question12);
        questionGroup3.add(question13);
        questionGroup3.add(question14);
        questionGroup3.add(question15);

        ArrayList<Question> questionGroup4 = new ArrayList<Question>();
        questionGroup4.add(question16);
        questionGroup4.add(question17);
        questionGroup4.add(question18);
        questionGroup4.add(question19);


        form1.setQuestions(questionGroup1);
        form2.setQuestions(questionGroup2);
        form3.setQuestions(questionGroup3);
        form4.setQuestions(questionGroup4);

            forms.save(form1);
            forms.save(form2);
            forms.save(form3);
            forms.save(form4);



          //  user.getPatients().add(patient);

//        }
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




    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> users() {

        return (List) users.findAll();
    }


    //ROUTE TO USER IN DATABASE AND SEND TO FRONT END
    //ASSIGN SESSION
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User u = users.findOne(id);

        return u;
    }









    // GET     /patients --- TELL Aaron to change endpt to this
    //get /patients
    @RequestMapping(path = "/users/{userId}/patients", method = RequestMethod.GET)
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






    @RequestMapping(path = "/patients", method = RequestMethod.GET)
    public List<Patient> patients() {

        return (List) patients.findAll();
    }


    @RequestMapping(path = "patients/{patientId}", method = RequestMethod.GET)
    public Patient patient(@PathVariable Integer patientId) {

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
    public FormPatientViewModel form(@PathVariable Integer formId, @PathVariable Integer patientId) {
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



    @RequestMapping(path = "/questions", method = RequestMethod.GET)
    public List<Question> questions() {

        return (List) questions.findAll();
    }




    @RequestMapping(path = "questions/{questionId}", method = RequestMethod.GET)
    public Question question(@PathVariable Integer questionId) {

        return questions.findById(questionId);
    }


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
