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

public class PutUpdateUserStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers;

    //Positive Case 1
    @Given("Put update user profil with valid token")
    public void putUpdateUserProfilWithValidToken() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateUserProfil.json");
        usersAPI.putUpdateUserProfil(authorizationUsers.getTokenUserUsers(), json);
    }
    @When("Send request put update user profil")
    public void sendRequestPutUpdateUserProfil() {
        SerenityRest.when().put(UsersAPI.PUT_UPDATE_USER_PROFIL_USERS);
    }
    @And("Validate json schema update user profil with valid parameter and valid body")
    public void validateJsonSchemaUpdateUserProfilWithValidParameterAndValidBody() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Users/PutUpdateUserProfilJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("update user profil with valid body and wrong token")
    public void updateUserProfilWithValidBodyAndWrongToken() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateUserProfil.json");
        usersAPI.putUpdateUserProfil(AuthorizationUsers.WRONG_TOKEN, json);
    }

    //Negative Case 2
    @Given("update user profil with invalid body and valid token")
    public void updateUserProfilWithInvalidBodyAndValidToken() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateInvalidUserProfil.json");
        usersAPI.putUpdateUserProfil(authorizationUsers.getTokenUserUsers(), json);
    }

    //Negative Case 3
    @Given("update user profil with valid token and blank body")
    public void updateUserProfilWithValidTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateInvalidUserProfil.json");
        usersAPI.putUpdateUserProfil(authorizationUsers.getTokenUserUsers(), json);
    }

    //Negative Case 4
    @Given("update user profil with blank token and valid body")
    public void updateUserProfilWithBlankTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateUserProfil.json");
        usersAPI.putUpdateUserProfil(AuthorizationUsers.WRONG_TOKEN, json);
    }

    //Negative Case 5
    @Given("update user profil with blank token and blank body")
    public void updateUserProfilWithBlankTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutUpdateInvalidUserProfil.json");
        usersAPI.putUpdateUserProfil(AuthorizationUsers.WRONG_TOKEN, json);
    }
}
