package data;


import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
     lastName = faker.name().lastName(),
     eMail = faker.internet().emailAddress(),
     phoneNumber = faker.numerify("##########"),
     streetAddress = faker.address().streetAddress(),
     gender = faker.demographic().sex(),
     day = String.format("%02d", faker.number().numberBetween(1, 28)),
     month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"),
     year = String.format("%s", faker.number().numberBetween(1990, 2024)),
     subjects = faker.options().option("Maths", "Hindi", "Biology", "Accounting",
            "Chemistry", "Computer Science", "Economics", "Social Studies"),
     hobbies = faker.options().option("Reading", "Sports", "Music"),
     file = "file.txt",
     state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
     city = selectCity(state);

    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}