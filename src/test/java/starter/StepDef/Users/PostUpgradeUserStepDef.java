package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PostUpgradeUserStepDef {

    //Positive Case 1
    @Given("Post upgrade user role from {string} to {string} with valid token and valid body")
    public void postUpgradeUserRoleFromUserToOwnerWithValidTokenAndValidBody() {
    }
    @When("Send request post upgrade user role from {string} to {string}")
    public void sendRequestPostUpgradeUserRoleFromUserToOwner() {
    }
    @And("Validate json schema post upgrade user role from {string} to {string}")
    public void validateJsonSchemaPostUpgradeUserRoleFromUserToOwner() {
    }

    //Negative Case 1
    @Given("Post upgrade user role from {string} to {string} with and wrong token valid body")
    public void postUpgradeUserRoleFromUserToOwnerWithAndWrongTokenValidBody() {
    }

    //Negative Case 2
    @Given("Post upgrade user role from {string} to {string} with valid token and blank body")
    public void postUpgradeUserRoleFromUserToOwnerWithValidTokenAndBlankBody() {
    }

    //Negative Case 3
    @Given("Post upgrade user role from {string} to {string} with blank token and blank body")
    public void postUpgradeUserRoleFromUserToOwnerWithBlankTokenAndBlankBody() {
    }
}
