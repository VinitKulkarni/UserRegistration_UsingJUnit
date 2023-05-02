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

    static void printRegistrationStatus(String matchingFor, String valueGiven, boolean result){
        System.out.println("VALIDATING => " +matchingFor);
        System.out.println("VALUE_GIVEN => " + valueGiven);
        System.out.println("RESULT => " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("USER REGISTRATION WITH REGEX");

        Scanner sc = new Scanner(System.in);
        UserRegistrationMain registrationObject = new UserRegistrationMain();

        //first name validation
        IRegistration firstNameObj = (stringValue) -> {
            return registrationObject.firstNameMatch(stringValue);
        };
        System.out.print("Enter first name:");
        String firstNameValue = sc.next();
        printRegistrationStatus("first_name",firstNameValue,firstNameObj.validate(firstNameValue));


        //last name validation
        IRegistration lastNameObj = (stringValue) -> {
            return registrationObject.lastNameMatch(stringValue);
        };
        System.out.print("Enter last name:");
        String lastNameValue = sc.next();
        printRegistrationStatus("last_name",lastNameValue,lastNameObj.validate(lastNameValue));


        //mobile number validation
        IRegistration mobileNumberObj = (stringValue) -> {
            return registrationObject.mobileNumberMatch(stringValue);
        };
        System.out.print("Enter mobile number:");
        String mobileNumberValue = sc.next();
        printRegistrationStatus("mobile_number",mobileNumberValue, mobileNumberObj.validate(mobileNumberValue));


        //email id validation
        IRegistration emailIdObj = (stringValue) -> {
            return registrationObject.emailIdMatch(stringValue);
        };
        System.out.print("Enter email Id:");
        String emailIdValue = sc.next();
        printRegistrationStatus("email_id",emailIdValue, emailIdObj.validate(emailIdValue));


        //password validation
        IRegistration passwordObj = (stringValue) -> {
            return registrationObject.passwordMatch(stringValue);
        };
        System.out.print("Enter password:");
        String passwordValue = sc.next();
        printRegistrationStatus("password",passwordValue, passwordObj.validate(passwordValue));
    }
}
