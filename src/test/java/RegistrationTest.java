import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {
    boolean userStatus = false;
    UserRegistrationMain registrationObject;

    @BeforeEach
    public void initialize(){
        registrationObject = new UserRegistrationMain();
    }

    @AfterEach
    public void userStatus(){
        if(userStatus)
            System.out.println("user is happy");
        else
            System.out.println("user is sad");
    }

    @Test
    public void givenFirstNameWhenValidatedShouldReturnTrue(){
        boolean result = registrationObject.firstNameMatch("Vinit"); //correct data given
        userStatus = result;
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenFirstNameWhenValidatedShouldReturnFalse(){
        boolean result = registrationObject.firstNameMatch("vinit1"); //data having digit
        userStatus = result;
        Assertions.assertEquals(false,result);
    }

    @Test
    public void givenLastNameWhenValidatedShouldReturnTrue(){
        boolean result = registrationObject.lastNameMatch("Kulkarni"); //correct data given
        userStatus = result;
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenLastNameWhenValidatedShouldReturnFalse(){
        boolean result = registrationObject.lastNameMatch("kULkarni"); //data having capital letter after first position
        userStatus = result;
        Assertions.assertEquals(false,result);
    }

    @Test
    public void givenEmailIdWhenValidatedShouldReturnTrue(){
        boolean result = registrationObject.emailIdMatch("vinit.kularni@yahoo.com.in"); //correct data given
        userStatus = result;
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenEmailIdWhenValidatedShouldReturnFalse(){
        boolean result = registrationObject.emailIdMatch("vinit@kularni@bridgelab.co.in"); //data having 2 @ symbols
        userStatus = result;
        Assertions.assertEquals(false,result);
    }

    @Test
    public void givenMobileNumberWhenValidatedShouldReturnTrue(){
        boolean result = registrationObject.mobileNumberMatch("91-9976543212"); //correct data given
        userStatus = result;
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenMobileNumberWhenValidatedShouldReturnFalse(){
        boolean result = registrationObject.mobileNumberMatch("91-999222020202"); //data has 12digit
        userStatus = result;
        Assertions.assertEquals(false,result);
    }


    @Test
    public void givenPasswordWhenValidatedTest1ShouldReturnTrue(){
        boolean result = registrationObject.passwordMatch("tiniV@12"); //correct data given
        userStatus = result;
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenPasswordWhenValidatedTest2ShouldReturnFalse(){
        boolean result = registrationObject.passwordMatch("tiniv@12"); //data not have least 1 capital letter
        userStatus = result;
        Assertions.assertEquals(false,result);
    }

    @Test
    public void givenPasswordWhenValidatedTest3ShouldReturnFalse(){
        boolean result = registrationObject.passwordMatch("tiniv@hQ"); //data not have least 1 digit
        userStatus = result;
        Assertions.assertEquals(false,result);
    }

}
