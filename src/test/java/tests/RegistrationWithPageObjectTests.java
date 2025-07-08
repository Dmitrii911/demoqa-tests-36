package tests;

import static data.TestDataGen.*;

import data.SuitTestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectTests extends TestBase {
    SuitTestData data = new SuitTestData();


    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .closeAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.eMail)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .setBirthDate(data.day, data.month, data.year)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadPicture(file)
                .setAddress(data.streetAddress)
                .selectStateAndCity(data.state, data.city)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.eMail)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber)
                .verifyResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .verifyResult("Subjects", data.subjects)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", file)
                .verifyResult("Address", data.streetAddress)
                .verifyResult("State and City", data.state + " " + data.city);
    }

    @Test
    void successfulMinFormTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber);
    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber("")
                .submitForm();

        registrationPage.verifyResultsModalAppearsNeg();
    }

    ;
}



