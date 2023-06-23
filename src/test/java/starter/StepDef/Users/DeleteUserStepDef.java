package starter.StepDef.Users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DeleteUserStepDef {

    //Positive Case 1
    @Given("Add user with {string} as full name, {string} as email, {string} as phone, and {string} as password")
    public void addUserWithAsFullNameAsEmailAsPhoneAndAsPassword(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
    }
    @When("Send request post delete user account")
    public void sendRequestPostDeleteUserAccount() {
    }
    @Given("Delete user account with valid token")
    public void deleteUserAccountWithValidToken() {
    }
    @When("Send request delete user account")
    public void sendRequestDeleteUserAccount() {
    }

    //Negative Case 1
    @Given("Delete user account with wrong token")
    public void deleteUserAccountWithWrongToken() {
    }

    //Negative Case 2
    @Given("Delete single data murid without token")
    public void deleteSingleDataMuridWithoutToken() {
    }
}
