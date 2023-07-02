package starter.StepDef.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Authentication;
import starter.Utils.Constants;

import java.io.File;

public class PostRegisterStepDef {
    @Steps
    Authentication authentication;

    @Given("Post Create account with valid json reqbody")
    public void postRegisterWithValidForm(){
        File json = new File(Constants.REQ_BODY_DIR+"authentication/registerValid.json");
        Authentication.postRegisterSuccess(json);
    }

    @Given("Post Create account with invalid json reqbody")
    public void postRegisterWithInvalidForm(){
        File json = new File(Constants.REQ_BODY_DIR+"authentication/registerInvalid.json");
        Authentication.postRegisterFailed(json);
    }

    @When("Send post create account")
    public void sendPostRegister() {
        SerenityRest.when().post(Authentication.REGISTER);
    }

    @And("Error message should be {string}")
    public void errorMessageShouldBe(String message) {
        SerenityRest.then().statusCode(400).body("error", org.hamcrest.Matchers.equalTo(message));
    }


}
