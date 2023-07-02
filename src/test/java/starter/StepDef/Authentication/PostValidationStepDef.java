package starter.StepDef.Authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.PlaygroundPro.Authentication;
import starter.Utils.RandomRegister;

public class PostValidationStepDef {


    @Given("Post validation with valid otp")
    public void postValidationWithValidOtp() throws Exception {
        String[] data = RandomRegister.RandomRegister();
        Authentication.postValidationWithValidOtp(data[1], data[0]);
    }

    @Given("Post validation with wrong otp")
    public void postValidationWithWrongOtp() throws Exception {
        String[] data = RandomRegister.RandomRegister();
        Authentication.postValidationWithWrongOTP(data[1]);
    }

    @Given("Post validation with invalid json reqbody")
    public void postValidationWithInvalidReqbody() throws Exception {
        String[] data = RandomRegister.RandomRegister();
        Authentication.postValidationWithInvalidReqbody(data[1]);
    }

    @Given("Post resend otp with valid json reqbody")
    public void postResendOtpWithValidJsonReqbody() throws Exception {
        String[] data = RandomRegister.RandomRegister();
        Authentication.postResendOtpWithValidJsonReqbody(data[2]);
    }

    @Given("Post resend otp with invalid json reqbody")
    public void postResendOtpWithInvalidJsonReqbody() throws Exception {
        Authentication.postResendOtpWithInvalidJsonReqbody();
    }

    @Given("Post resend otp with invalid email")
    public void postResendOtpWithInvalidEmail() throws Exception {
        Authentication.postResendOtpWithInvalidEmail();
    }

    @When("Send Post Validation")
    public void sendPostValidation() {

        Response response = SerenityRest.when().post(Authentication.VALIDATION);
        System.out.println(response.jsonPath().getString("message"));
    }
    @When("Send Post Resend otp")
    public void sendPostResendOtp() {

        Response response = SerenityRest.when().post(Authentication.RESEND_OTP);
        System.out.println(response.jsonPath().getString("message"));
    }
}
