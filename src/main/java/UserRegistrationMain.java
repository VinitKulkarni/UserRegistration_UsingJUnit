import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationMain {
    public boolean firstNameMatch(String firstName){
        return firstNameValidation(firstName);
    }

    public static boolean firstNameValidation(String value){
        Pattern pattern = Pattern.compile("^[A-Z]{1,1}[a-z]{2,}$");
        Matcher matcher = pattern.matcher(value);
        return (matcher.matches());
    }
    public static void main(String[] args) {
        System.out.println("USER REGISTRATION WITH REGEX");

        Scanner sc = new Scanner(System.in);
        UserRegistrationMain object = new UserRegistrationMain();

        System.out.print("Enter the first name:");
        String firstNameValue = sc.next();
        System.out.println(object.firstNameMatch(firstNameValue) + " value given");
    }
}
