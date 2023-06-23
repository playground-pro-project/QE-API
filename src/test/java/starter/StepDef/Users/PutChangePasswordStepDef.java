package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PutChangePasswordStepDef {

    //Positive Case 1
    @When("Send request post change user password")
    public void sendRequestPostChangeUserPassword() {
    }
    @Given("Put change user password with valid token and valid body")
    public void putChangeUserPasswordWithValidTokenAndValidBody() {
    }
    @When("Send request put change user password")
    public void sendRequestPutChangeUserPassword() {
    }
    @And("Validate json schema change user password with valid token and valid body")
    public void validateJsonSchemaChangeUserPasswordWithValidTokenAndValidBody() {
    }

    //Negative Case 1
    @Given("Put change user password with wrong token and valid body")
    public void putChangeUserPasswordWithWrongTokenAndValidBody() {
    }

    //Negative Case 2
    @Given("Put change user password with valid token and invalid body")
    public void putChangeUserPasswordWithValidTokenAndInvalidBody() {
    }

    //Negative Case 3
    @Given("Put change user password with valid token and blank body")
    public void putChangeUserPasswordWithValidTokenAndBlankBody() {
    }

    //Negative Case 4
    @Given("Put change user password with blank token and valid body")
    public void putChangeUserPasswordWithBlankTokenAndValidBody() {
    }

    //Negative Case 5
    @Given("Put change user password with blank token and blank body")
    public void putChangeUserPasswordWithBlankTokenAndBlankBody() {
    }
}
