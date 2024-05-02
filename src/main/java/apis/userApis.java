package apis;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import pojoBody.users.UserLoginBody;
import pojoBody.users.UserRegisterBody;

import java.util.List;

public class userApis {

    /**
    Variables
     **/
    private SHAFT.API api;

    /**
     Constructor
     **/
    public userApis (SHAFT.API api) {this.api = api;}

    /**
    Services
     **/
    UserRegisterBody registerBody;
    UserLoginBody loginBody;


    /******** Create Account ********/
    /**
     * >>	Keywords
     *
     * @param username  String Value From testDataFiles AccountData.json
     * @param firstName String Value From testDataFiles AccountData.json
     * @param lastName  String Value From testDataFiles AccountData.json
     * @param email     String Value From testDataFiles AccountData.json
     * @param password  String Value From testDataFiles AccountData.json
     * @param phone     String Value From testDataFiles AccountData.json
     */

    @Step("API Create User Account")
    public  void createUserAccount(String username, String firstName, String lastName, String email,
                                   String password, String phone, int status)  {
         registerBody = UserRegisterBody.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .status(status)
                .build();

        api.post("user/createWithList")
                .setRequestBody(List.of(registerBody))
                .setContentType(ContentType.JSON)
                .perform();
    }
    @Step(" API Login Account ")
    public  void LoginUserAccount(String username, String password) {
         loginBody = UserLoginBody.builder()
                .username(username)
                .password(password)
                .build();

        api.get("user/login")
                .setRequestBody(List.of(loginBody))
                .setContentType(ContentType.JSON)
                .perform();
    }
        @Step(" API Log out ")
           public  void LogOutAccount() {

          api.get("user/logout")
                .setContentType(ContentType.JSON)
                .perform();
    }
}


