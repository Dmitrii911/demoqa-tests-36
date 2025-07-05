package tests;

import static data.TestData.*;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .closeAd()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(file)
                .setAddress(streetAddress)
                .selectStateAndCity(state, city)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", eMail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", file)
                .verifyResult("Address", streetAddress)
                .verifyResult("State and City", state + " " + city);
    }

    @Test
    void successfulMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(phoneNumber)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber);
    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber("")
                .submitForm();

        registrationPage.verifyResultsModalAppearsNeg();
    }

    ;
}



