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
        UserRegistrationMain registrationObject = new UserRegistrationMain();

        //first name validation
        IRegistration firstNameObj = (stringValue) -> {
            return registrationObject.firstNameMatch(stringValue);
        };
        try {
            System.out.print("Enter first name:");
            String firstNameValue = sc.next();
            if (firstNameObj.validate(firstNameValue) == false)
                throw new RegistrationException("Invalid data entered for firstName");
        } catch (RegistrationException e){
            System.out.println(e);
        }


        //last name validation
        IRegistration lastNameObj = (stringValue) -> {
            return registrationObject.lastNameMatch(stringValue);
        };
        try{
        System.out.print("Enter last name:");
        String lastNameValue = sc.next();
        if(lastNameObj.validate(lastNameValue) == false)
            throw new RegistrationException("Invalid data entered for lastName");
        } catch (RegistrationException e){
            System.out.println(e);
        }


        //mobile number validation
        IRegistration mobileNumberObj = (stringValue) -> {
            return registrationObject.mobileNumberMatch(stringValue);
        };
        try{
        System.out.print("Enter mobile number:");
        String mobileNumberValue = sc.next();
        if(mobileNumberObj.validate(mobileNumberValue) == false)
            throw new RegistrationException("Invalid data entered for mobileNumber");
        } catch (RegistrationException e){
            System.out.println(e);
        }


        //email id validation
        IRegistration emailIdObj = (stringValue) -> {
            return registrationObject.emailIdMatch(stringValue);
        };
        try{
        System.out.print("Enter email Id:");
        String emailIdValue = sc.next();
        if(emailIdObj.validate(emailIdValue) == false)
            throw new RegistrationException("Invalid data entered for emailId");
        } catch (RegistrationException e){
            System.out.println(e);
        }


        //password validation
        IRegistration passwordObj = (stringValue) -> {
            return registrationObject.passwordMatch(stringValue);
        };
        try{
        System.out.print("Enter password:");
        String passwordValue = sc.next();
        if(passwordObj.validate(passwordValue) == false)
            throw new RegistrationException("Invalid data entered for password");
        } catch (RegistrationException e){
            System.out.println(e);
        }
    }
}
