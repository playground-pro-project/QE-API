package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.UsersAPI;
import starter.Utils.Constants;
import starter.Utils.Users.AuthorizationUsers;

import java.io.File;

public class PostUpgradeUserStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers = new AuthorizationUsers();

    //Positive Case 1
    @Given("Post upgrade user role from user to owner with valid token and valid body")
    public void postUpgradeUserRoleFromUserToOwnerWithValidTokenAndValidBody() {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"KTP.png");
        usersAPI.postUpgradeUserRole(authorizationUsers.getTokenUserUsers(), imageFile);
    }
    @When("Send request post upgrade user role from 'user' to 'owner'")
    public void sendRequestPostUpgradeUserRoleFromUserToOwner() {
        SerenityRest.when().post(UsersAPI.POST_UPGRADE_USER_ROLE_USERS);
    }
    @And("Validate json schema post upgrade user role from 'user' to 'owner'")
    public void validateJsonSchemaPostUpgradeUserRoleFromUserToOwner() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Users/PostUpgradeUserStepDefJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Post upgrade user role from 'user' to 'owner' with wrong token and valid body")
    public void postUpgradeUserRoleFromUserToOwnerWithAndWrongTokenValidBody() {
        File imageFile = new File(Constants.CSV_INVALID_FILE_REQUEST+"InvalidFile.csv");
        usersAPI.postUpgradeUserRole(AuthorizationUsers.WRONG_TOKEN, imageFile);
    }

    //Negative Case 2
    @Given("Post upgrade user role from 'user' to 'owner' with valid token and blank body")
    public void postUpgradeUserRoleFromUserToOwnerWithValidTokenAndBlankBody() {
        usersAPI.postUpgradeUserRoleWithBlankBody(authorizationUsers.getTokenUserUsers());
    }

    //Negative Case 3
    @Given("Post upgrade user role from 'user' to 'owner' with blank token and blank body")
    public void postUpgradeUserRoleFromUserToOwnerWithBlankTokenAndBlankBody() {
        usersAPI.postUpgradeUserRoleWithBlankBody(AuthorizationUsers.WRONG_TOKEN);
    }

    //Negative Case 4
    @Given("Post upgrade user role from 'user' to 'owner' with valid token and invalid body")
    public void postUpgradeUserRoleFromUserToOwnerWithValidTokenAndInvalidBody() {
        File imageFile = new File(Constants.CSV_INVALID_FILE_REQUEST+"InvalidFile.csv");
        usersAPI.postUpgradeUserRole(authorizationUsers.getTokenUserUsers(), imageFile);
    }
}
