package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectTests extends TestBase {

    @Test
    void successfulFillFormTest() {

        String firstName = "Ivan";
        String lastName = "Ivanov";

        registrationPage.openPage()
                .closeAd()
                .setFirstName(firstName)
                .setLastName(lastName)
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

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + lastName)
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
        String firstName = "Ivan";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("8965412365")
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " Ivanov")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8965412365");
    }

    @Test
    void negativeMinFormTest() {
        String firstName = "Ivan";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("")
                .submitForm();

        registrationPage.verifyResultsModalAppearsNeg();
    }
}

