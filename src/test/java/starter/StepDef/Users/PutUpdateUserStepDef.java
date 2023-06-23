package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PutUpdateUserStepDef {

    //Positive Case 1
    @When("Send request post update user profil")
    public void sendRequestPostUpdateUserProfil() {
    }
    @Given("Put update user profil with valid token")
    public void putUpdateUserProfilWithValidToken() {
    }
    @When("Send request put update user profil")
    public void sendRequestPutUpdateUserProfil() {
    }
    @And("Validate json schema update user profil with valid parameter and valid body")
    public void validateJsonSchemaUpdateUserProfilWithValidParameterAndValidBody() {
    }

    //Negative Case 1
    @Given("update user profil with valid body and wrong token")
    public void updateUserProfilWithValidBodyAndWrongToken() {
    }

    //Negative Case 2
    @Given("update user profil with invalid body and valid token")
    public void updateUserProfilWithInvalidBodyAndValidToken() {
    }

    //Negative Case 3
    @Given("update user profil with valid token and blank body")
    public void updateUserProfilWithValidTokenAndBlankBody() {
    }

    //Negative Case 4
    @Given("update user profil with blank token and valid body")
    public void updateUserProfilWithBlankTokenAndValidBody() {
    }

    //Negative Case 5
    @Given("update user profil with blank token and blank body")
    public void updateUserProfilWithBlankTokenAndBlankBody() {
    }
}
