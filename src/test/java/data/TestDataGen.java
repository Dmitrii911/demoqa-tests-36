package data;


import com.github.javafaker.Faker;

public class TestDataGen {
    static Faker faker = new Faker();





    public String firstName() {
       return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }


    public String eMail() {
        return faker.internet().emailAddress();
    }

    public String phoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String streetAddress() {
        return faker.address().streetAddress();
    }

    public String gender() {
        return faker.demographic().sex();
    }

    public String day() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String month() {
        return faker.options().option(TestData.MONTH_OPTIONS);
    }

    public String year() {
        return String.format("%s", faker.number().numberBetween(1990, 2024));
    }

    public String subjects() {
        return faker.options().option(TestData.SUBJECT_OPTIONS);
    }

    public String hobbies() {
        return faker.options().option(TestData.HOBBIES_OPTIONS);
    }

    public String state() {
        return faker.options().option(TestData.STATE_OPTIONS);
    }

    public static String
            state = faker.options().option(TestData.STATE_OPTIONS);

    public String city() {
        return selectCity(state);
    }
    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option(TestData.CITY_NCR);
            case "Uttar Pradesh" -> faker.options().option(TestData.CITY_UTTAR);
            case "Haryana" -> faker.options().option(TestData.CITY_HARYANA);
            case "Rajasthan" -> faker.options().option(TestData.CITY_RAYASTHAN);
            default -> null;
        };
    }
    public static String
            file = "file.txt";
}