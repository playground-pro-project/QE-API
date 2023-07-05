package starter.StepDef.Users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.UsersAPI;
import starter.Utils.Users.AuthorizationUsers;
import starter.Utils.Users.PayloadUsers;

public class DeleteUserStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers = new AuthorizationUsers();
    PayloadUsers payloadUsers = new PayloadUsers();

    //Positive Case 1
    @Given("Delete user account with valid token")
    public void deleteUserAccountWithValidToken() {
        usersAPI.deleteUserUsers(authorizationUsers.getTokenUserUsersKhususDelete());
    }
    @When("Send request delete user account")
    public void sendRequestDeleteUserAccount() {
        SerenityRest.when().delete(UsersAPI.DELETE_USER_USERS);
    }

    //Negative Case 1
    @Given("Delete user account with wrong token")
    public void deleteUserAccountWithWrongToken() {
        usersAPI.deleteUserUsers(AuthorizationUsers.WRONG_TOKEN);
    }

    //Negative Case 2
    @Given("Delete single data user without token")
    public void deleteSingleDataMuridWithoutToken() {
        usersAPI.deleteUserWithoutTokenUsers();
    }
}
