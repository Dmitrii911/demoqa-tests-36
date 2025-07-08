package data;



public class SuitTestData {
    TestDataGen data = new TestDataGen();

    public String firstName = data.firstName();
    public String lastName = data.lastName();
    public String eMail = data.eMail();
    public String phoneNumber = data.phoneNumber();
    public String streetAddress = data.streetAddress();
    public String gender = data.gender();
    public String day = data.day();
    public String month = data.month();
    public String year = data.year();
    public String subjects = data.subjects();
    public String hobbies = data.hobbies();
    public String state = data.state();
    public String city = data.city();

}
