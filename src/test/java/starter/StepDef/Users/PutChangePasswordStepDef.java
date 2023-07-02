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

public class PutChangePasswordStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers = new AuthorizationUsers();

    //Positive Case 1
    @Given("Put change user password with valid token and valid body")
    public void putChangeUserPasswordWithValidTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangePasswordUser.json");
        usersAPI.putChangeUserPasswordUsers(authorizationUsers.getTokenUserUsers(), json);
    }
    @When("Send request put change user password")
    public void sendRequestPutChangeUserPassword() {
        SerenityRest.when().put(UsersAPI.PUT_CHANGE_USER_PASSWORD_USERS);
    }
    @And("Validate json schema change user password with valid token and valid body")
    public void validateJsonSchemaChangeUserPasswordWithValidTokenAndValidBody() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Users/PutChangePasswordUsersJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Put change user password with wrong token and valid body")
    public void putChangeUserPasswordWithWrongTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangePasswordUser.json");
        usersAPI.putChangeUserPasswordUsers(AuthorizationUsers.WRONG_TOKEN, json);
    }

    //Negative Case 2
    @Given("Put change user password with valid token and invalid body")
    public void putChangeUserPasswordWithValidTokenAndInvalidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangeInvalidPassword.json");
        usersAPI.putChangeUserPasswordUsers(authorizationUsers.getTokenUserUsers(), json);
    }

    //Negative Case 3
    @Given("Put change user password with valid token and blank body")
    public void putChangeUserPasswordWithValidTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangeInvalidPassword.json");
        usersAPI.putChangeUserPasswordUsers(authorizationUsers.getTokenUserUsers(), json);
    }

    //Negative Case 4
    @Given("Put change user password with blank token and valid body")
    public void putChangeUserPasswordWithBlankTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangePasswordUser.json");
        usersAPI.putChangeUserPasswordUsers(AuthorizationUsers.WRONG_TOKEN, json);
    }

    //Negative Case 5
    @Given("Put change user password with blank token and blank body")
    public void putChangeUserPasswordWithBlankTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Users/PutChangePasswordUser.json");
        usersAPI.putChangeUserPasswordUsers(AuthorizationUsers.WRONG_TOKEN, json);
    }
}
