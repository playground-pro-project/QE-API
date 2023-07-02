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

public class PutChangePictureStepDef {
    @Steps
    UsersAPI usersAPI;
    AuthorizationUsers authorizationUsers = new AuthorizationUsers();

    //Positive Case 1
    @Given("Change user profile picture with valid token and valid body")
    public void changeUserProfilePictureWithValidTokenAndValidBody() {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"Kimmy.jpg");
        usersAPI.putChangeProfilPictureUsers(authorizationUsers.getTokenUserUsers(), imageFile);
    }
    @When("Send request put change user profile picture")
    public void sendRequestPutChangeUserProfilePicture() {
        SerenityRest.when().put(UsersAPI.PUT_CHANGE_PROFIL_PICTURE_USERS);
    }
    @And("Validate json schema change user profile picture with valid token and valid body")
    public void validateJsonSchemaChangeUserProfilePictureWithValidTokenAndValidBody() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Users/PutChangeProfilPictureJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Change user profile picture with wrong token and valid body")
    public void changeUserProfilePictureWithWrongTokenAndValidBody() {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"Kimmy.jpg");
        usersAPI.putChangeProfilPictureUsers(AuthorizationUsers.WRONG_TOKEN, imageFile);
    }

    //Negative Case 2
    @Given("Change user profile picture with valid token and invalid body")
    public void changeUserProfilePictureWithValidTokenAndInvalidBodyJson() {
        File imageFile = new File(Constants.CSV_INVALID_FILE_REQUEST+"InvalidFile.csv");
        usersAPI.putChangeProfilPictureUsers(authorizationUsers.getTokenUserUsers(), imageFile);
    }

    //Negative Case 3
    @Given("Change user profile picture with valid token and blank body")
    public void changeUserProfilePictureWithValidTokenAndBlankBody() {
        usersAPI.putChangeProfilPictureWithBlankBody(authorizationUsers.getTokenUserUsers());
    }

    //Negative Case 4
    @Given("Change user profile picture with blank token and invalid body")
    public void changeUserProfilePictureWithBlankTokenAndInvalidBody() {
        File imageFile = new File(Constants.CSV_INVALID_FILE_REQUEST+"InvalidFile.csv");
        usersAPI.putChangeProfilPictureUsers(AuthorizationUsers.WRONG_TOKEN, imageFile);
    }

    //Negative Case 5
    @Given("Change user profile picture with blank token and blank body")
    public void changeUserProfilePictureWithBlankTokenAndBlankBody() {
        usersAPI.putChangeProfilPictureWithBlankBody(AuthorizationUsers.WRONG_TOKEN);
    }
}
