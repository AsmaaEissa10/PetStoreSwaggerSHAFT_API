import apis.BaseApis;
import apis.userApis;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserApisTest {
    private SHAFT.API api;
    private SHAFT.TestData.JSON testData;
    private String currentTime;
    @Test(priority = 1)
    public void RegisterTest(){
        new userApis(api)
                .createUserAccount( testData.getTestData("UserName"),
                testData.getTestData("UserFirstName"),
                testData.getTestData("UserLastName"),
                testData.getTestData("Email"),
                testData.getTestData("Password"),
                testData.getTestData("Phone"),
                Integer.parseInt(testData.getTestData("userStatus")));
    }
    @Test(priority = 2)
    public void LoginTest() {
        new userApis(api)
                .LoginUserAccount( testData.getTestData("UserName"),
                        testData.getTestData("Password"));
    }

    @Test(priority = 3)
    public void LogOutTest() {
        new userApis(api).LogOutAccount();
    }


    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/RegisterData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        api = new SHAFT.API(BaseApis.ApisBaseUrl);
        currentTime = String.valueOf(System.currentTimeMillis());
    }
}
