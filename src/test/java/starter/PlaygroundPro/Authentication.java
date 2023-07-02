package starter.PlaygroundPro;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Authentication {
    public static String REGISTER = Constants.BASE_URL + "/register";
    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String VALIDATION = Constants.BASE_URL + "/validation";
    public static String RESEND_OTP = Constants.BASE_URL + "/resend-otp";

    //Register
    @Step("Post Create account with valid json reqbody")
    public static void postRegisterSuccess(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post Create account with invalid json reqbody")
    public static void postRegisterFailed(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    //Login
    @Step("Post Login with valid json reqbody")
    public static void postLoginWithValidFormData(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post Login with invalid json reqbody")
    public static void postLoginWithInvalidFormData(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Validation
    @Step("Post Validation with valid json reqbody")
    public static void postValidationWithValidOtp(String userId, String otp) {

        SerenityRest.given().contentType("multipart/form-data")
                .multiPart("user_id", userId)
                .multiPart("otp_code", otp);

    }

    @Step("Post Validation with wrong otp")
    public static void postValidationWithWrongOTP(String userId) {

        SerenityRest.given().contentType("multipart/form-data")
                .multiPart("user_id", userId)
                .multiPart("otp_code","123988");

    }


    @Step("Post Validation with invalid json reqbody")
    public static void postValidationWithInvalidReqbody(String userId) {

        SerenityRest.given().contentType("multipart/form-data")
                .multiPart("user_id", userId)
                .multiPart("otp_code","123456");
    }



    @Step("Post Resend otp with valid json reqbody")
    public static void postResendOtpWithValidJsonReqbody(String email) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("email", email);
        SerenityRest.given().contentType(ContentType.JSON).body(body);
    }

    @Step("Post Resend otp with invalid email")
    public static void postResendOtpWithInvalidEmail() {

        Map<String, String> body = new HashMap<String, String>();
        body.put("email", "invalidemail@gmefwfail.com");
        SerenityRest.given().contentType(ContentType.JSON).body(body);
    }

    @Step("Post Resend otp with invalid json reqbody")
    public static void postResendOtpWithInvalidJsonReqbody() {

        Map<String, Integer> body = new HashMap<String, Integer>();
        body.put("email", 1);
        SerenityRest.given().contentType(ContentType.JSON).body(body);
    }



}