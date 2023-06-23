package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.UsersAPI;
import starter.Utils.AuthorizationUsers;
import starter.Utils.Constants;

import java.io.File;

public class GetUserProfilStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers;

    //Positive Case 1
    @Given("Get user profil with valid path")
    public void getUserProfilWithValidPath() {
        usersAPI.getUserProfilUsers(authorizationUsers.getTokenUserUsers());
    }
    @When("Send request get user profil")
    public void sendRequestGetUserProfil() {
        SerenityRest.when().get(UsersAPI.GET_USER_PROFIL);
    }
    @And("Validate json schema get user profil with valid path")
    public void validateJsonSchemaGetUserProfilWithValidPath() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Users/GetUserProfilWithValidPath.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get user profil with invalid path")
    public void getUserProfilWithInvalidPath() {
        usersAPI.getUserProfilUsers(authorizationUsers.getTokenUserUsers());
    }
    @When("Send request get user profils")
    public void sendRequestGetUserProfils() {
        SerenityRest.when().get(UsersAPI.GET_USER_PROFIL_INVALID);
    }

    //Negative Case 2
    @Given("Get user profil with valid path and wrong token")
    public void getUserProfilWithValidPathAndWrongToken() {
        usersAPI.getUserProfilUsers(AuthorizationUsers.WRONG_TOKEN);
    }

}
