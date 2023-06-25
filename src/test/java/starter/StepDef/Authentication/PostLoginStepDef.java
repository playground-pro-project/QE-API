package starter.StepDef.Authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Authentication;


public class PostLoginStepDef {
    @Steps
    Authentication authentication;

    @Given("Post login with valid form data email {string} password {string}")
    public void postLoginWithValidForm(String email, String password){
        Authentication.postLoginWithValidFormData(email,password);
    }

    @Given("Post login with invalid form data email {int} password {string}")
    public void postLoginWithInvalidFormData(int email, String password){
        Authentication.postLoginWithInvalidFormData(email, password);
    }

    @When("Send post login")
    public void sendPostLogin(){
        SerenityRest.when().post(Authentication.LOGIN);
    }
}
