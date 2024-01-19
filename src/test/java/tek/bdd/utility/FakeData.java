package tek.bdd.utility;

public class FakeData {

    public static String emailAddress(String firstName, String lastName) {
        int random = (int) (Math.random() * 100000);
        return firstName + lastName + random + "@tekschool.us";
    }
}
