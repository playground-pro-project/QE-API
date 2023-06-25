package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class Authentication {
    public static String REGISTER = Constants.BASE_URL + "/register";
    public static String LOGIN = Constants.BASE_URL + "/login";


    //Register
    @Step("Post Create account with valid form data")
    public static void postRegisterSuccess(String full_name, String email, String phone, String password) {
        SerenityRest.given().contentType("multipart/form-data").
                multiPart("full_name", full_name).
                multiPart("email", email).
                multiPart("phone", phone).
                multiPart("password", password);
    }

    @Step("Post Create account with invalid form data")
    public static void postRegisterFailed(String full_name, int email, String phone, String password) {
        SerenityRest.given().contentType("multipart/form-data").
                multiPart("full_name", full_name).
                multiPart("email", email).
                multiPart("phone", phone).
                multiPart("password", password);
    }


    //Login
    @Step("Post Login with valid form data")
    public static void postLoginWithValidFormData(String email, String password) {
        SerenityRest.given().contentType("multipart/form-data").
                multiPart("email", email).
                multiPart("password", password);
    }

    @Step("Post Login with invalid form data")
    public static void postLoginWithInvalidFormData(int email, String password) {
        SerenityRest.given().contentType("multipart/form-data").
                multiPart("email", email).
                multiPart("password", password);
    }

}