package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PutChangePictureStepDef {

    //Positive Case 1
    @When("Send request post change user profile picture")
    public void sendRequestPostChangeUserProfilePicture() {
    }
    @Given("Change user profile picture with valid token and valid body")
    public void changeUserProfilePictureWithValidTokenAndValidBody() {
    }
    @When("Send request put change user profile picture")
    public void sendRequestPutChangeUserProfilePicture() {
    }
    @And("Validate json schema change user profile picture with valid token and valid body")
    public void validateJsonSchemaChangeUserProfilePictureWithValidTokenAndValidBody() {
    }

    //Negative Case 1
    @Given("Change user profile picture with wrong token and valid body")
    public void changeUserProfilePictureWithWrongTokenAndValidBody() {
    }

    //Negative Case 2
    @Given("Change user profile picture with valid token and invalid body json")
    public void changeUserProfilePictureWithValidTokenAndInvalidBodyJson() {
    }

    //Negative Case 3
    @Given("Change user profile picture with valid token and blank body")
    public void changeUserProfilePictureWithValidTokenAndBlankBody() {
    }

    //Negative Case 4
    @Given("Change user profile picture with blank token and invalid body")
    public void changeUserProfilePictureWithBlankTokenAndInvalidBody() {
    }

    //Negative Case 5
    @Given("Change user profile picture with blank token and blank body")
    public void changeUserProfilePictureWithBlankTokenAndBlankBody() {
    }
}
