package starter.StepDef.Authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Authentication;
import starter.Utils.Constants;

import java.io.File;


public class PostLoginStepDef {
    @Steps
    Authentication authentication;

    @Given("Post login with valid json reqbody")
    public void postLoginWithValidForm(){
        File json = new File(Constants.REQ_BODY_DIR+"authentication/loginValid.json");
        Authentication.postLoginWithValidFormData(json);
    }

    @Given("Post login with invalid json reqbody")
    public void postLoginWithInvalidFormData(){
        File json = new File(Constants.REQ_BODY_DIR+"authentication/loginInvalid.json");
        Authentication.postLoginWithInvalidFormData(json);
    }

    @Given("Post login with wrong email or password")
    public void postLoginWithInvalidEmailOrPassword(){
        File json = new File(Constants.REQ_BODY_DIR+"authentication/loginWrongEmailOrPassword.json");
        Authentication.postLoginWithInvalidFormData(json);
    }

    @When("Send post login")
    public void sendPostLogin(){
        SerenityRest.when().post(Authentication.LOGIN);
    }
}
