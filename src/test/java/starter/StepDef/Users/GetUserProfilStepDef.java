package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetUserProfilStepDef {

    //Positive Case 1
    @Given("Get user profil with valid path")
    public void getUserProfilWithValidPath() {
    }
    @When("Send request get user profil")
    public void sendRequestGetUserProfil() {
    }
    @And("Validate json schema get user profil with valid path")
    public void validateJsonSchemaGetUserProfilWithValidPath() {
    }

    //Negative Case 1
    @Given("Get user profil with invalid path")
    public void getUserProfilWithInvalidPath() {
    }

    //Negative Case 2
    @Given("Get user profil with valid path and wrong token")
    public void getUserProfilWithValidPathAndWrongToken() {
    }
}
