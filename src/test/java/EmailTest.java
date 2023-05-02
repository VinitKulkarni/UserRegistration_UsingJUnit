import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class EmailTest {

    private String email;
    private boolean isEmail;
    UserRegistrationMain registrationObject;


    public EmailTest(String email, boolean isEmail) {
        this.email = email;
        this.isEmail = isEmail;
    }

    @Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][] {
                {"abc",false},
                {"abc@.com.my",false},
                {"abc@abc@gmail.com",false},
                {"abc@gmail.com.aa.au",false},
                {"abc()*@gmail.com",false},
                {"abc123@gmail.com",true},
                {"abc@gmail.org.in",true}
        });
    }

    @Before
    public void initialize(){
        registrationObject = new UserRegistrationMain();
    }

    @Test
    public void givenMultipleEmailIdWhenValidatedShouldReturnTrue(){
        boolean result = registrationObject.multipleEmailIdMatch(email, isEmail);
        Assertions.assertEquals(isEmail,result);
    }

}
