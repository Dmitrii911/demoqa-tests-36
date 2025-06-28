package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPagesObjectsTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        String userName = "Ivan";

        registrationPages.openPage()
                .setFirstName(userName)
                .setLastName("Ivanov")
                .setEmail("Ivanov@ivan.com")
                .setGender("Male")
                .setNumber("8965412365")
                .setBirthDate("25", "November", "1917")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .uploadPicture("file.txt")
                .setAddress("123 Main St.")
                .selectStateAndCity("NCR","Delhi" )
                .submitForm();

        registrationPages.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Ivanov")
                .verifyResult("Student Email", "Ivanov@ivan.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8965412365")
                .verifyResult("Date of Birth", "25 November,1917")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "file.txt")
                .verifyResult("Address", "123 Main St.")
                .verifyResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulMinFormTest() {
        String userName = "Ivan";

        registrationPages.openPage()
                .setFirstName(userName)
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("8965412365")
                .submitForm();

        registrationPages.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Ivanov")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8965412365");
    }

    @Test
    void negativeMinFormTest() {
        String userName = "Ivan";

        registrationPages.openPage()
                .setFirstName(userName)
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("")
                .submitForm();

        registrationPages.verifyResultsModalAppearsNeg();
    }
}

