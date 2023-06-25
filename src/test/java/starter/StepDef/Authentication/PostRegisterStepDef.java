package starter.StepDef.Authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Authentication;

public class PostRegisterStepDef {
    @Steps
    Authentication authentication;

    @Given("Post Create account with valid form data name {string} email {string} phone {string} password {string}")
    public void postRegisterWithValidForm(String full_name,String email, String phone, String password){
        Authentication.postRegisterSuccess(full_name, email,phone,password);
    }

    @Given("Post Create account with invalid form data name {string} email {int} phone {string} password {string}")
    public void postRegisterWithInvalidForm(String full_name,int email, String phone, String password){
        Authentication.postRegisterFailed(full_name, email,phone,password);
    }


    @When("Send post create account")
    public void sendPostRegister() {
        SerenityRest.when().post(Authentication.REGISTER);
    }

}
