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

    public boolean lastNameMatch(String lastName){
        return lastNameValidation(lastName);
    }
    public static boolean lastNameValidation(String value){
        Pattern pattern = Pattern.compile("^[A-Z]{1,1}[a-z]{2,}$");
        Matcher matcher = pattern.matcher(value);
        return (matcher.matches());
    }

    public boolean emailIdMatch(String emailId){
        return emailIdValidation(emailId);
    }
    public static boolean emailIdValidation(String value){
        Pattern pattern = Pattern.compile("^([a-z0-9]+([-$%&+.]?[0-9a-z]+))[@][a-z0-9]+[.][a-z]{3,}([.][a-z]{2,})?$");
        Matcher matcher = pattern.matcher(value);
        return (matcher.matches());
    }

    public boolean mobileNumberMatch(String mobileNumber) {
        return mobileNumberValidation(mobileNumber);
    }
    public static boolean mobileNumberValidation(String value){
        Pattern pattern = Pattern.compile("^[1-9]{1}+[0-9]{1}+[-][0-9]{10}$");
        Matcher matcher = pattern.matcher(value);
        return (matcher.matches());
    }

    public boolean passwordMatch(String password){
        return passwordValidation(password);
    }
    public static boolean passwordValidation(String value){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=[^%_#&$+=@]*[%_#&$+=@][^%_#&$+*^=@]*$).{8}$");
        Matcher matcher = pattern.matcher(value);
        return (matcher.matches());
    }

    public boolean multipleEmailIdMatch(String emailId, boolean result){
        return emailIdValidation(emailId);
    }


    public static void main(String[] args) {
        System.out.println("USER REGISTRATION WITH REGEX");

        Scanner sc = new Scanner(System.in);
        UserRegistrationMain object = new UserRegistrationMain();

        System.out.print("Enter the first name:");
        String firstNameValue = sc.next();
        System.out.println(object.firstNameMatch(firstNameValue) + " value given");

        System.out.print("Enter the last name:");
        String lastNameValue = sc.next();
        System.out.println(object.lastNameMatch(lastNameValue) + " value given");

        System.out.print("Enter the Email ID:");
        String emailIdValue = sc.next();
        System.out.println(object.emailIdMatch(emailIdValue) + " value given");

        System.out.print("Enter the Mobile Number:");
        String mobileNumberValue = sc.next();
        System.out.println(object.mobileNumberMatch(mobileNumberValue) + " value given");

        System.out.print("Enter the Password:");
        String passwordValue = sc.next();
        System.out.println(object.passwordMatch(passwordValue) + " value given");
    }
}
