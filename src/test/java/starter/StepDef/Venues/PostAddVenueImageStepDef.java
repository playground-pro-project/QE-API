package starter.StepDef.Venues;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.VenuesAPI;
import starter.Utils.Constants;
import starter.Utils.Venues.AuthorizationVenues;

import java.io.File;

public class PostAddVenueImageStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Post add venue image with {string} valid parameter, valid body, and valid token")
    public void postAddVenueImageWithValidParameterValidBodyAndValidToken(String id) {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"lapanganBola1.jpg");
        venuesAPI.postAddVenueImage(authorizationVenues.getTokenUserVenues(), id, imageFile);
    }
    @When("Send request post add venue image")
    public void sendRequestPostAddVenueImage() {
        SerenityRest.when().post(VenuesAPI.POST_ADD_VENUE_IMAGES);
    }
    @And("Validate json schema post add venue image")
    public void validateJsonSchemaPostAddVenueImage() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/PostAddVenueImageJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Post add venue image with {string} valid parameter, valid body, and wrong token")
    public void postAddVenueImageWithValidParameterValidBodyAndWrongToken(String id) {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"lapanganBola1.jpg");
        venuesAPI.postAddVenueImage(AuthorizationVenues.WRONG_TOKEN_VENUES, id, imageFile);
    }

    //Negative Case 2
    @Given("Post add venue image with {string} invalid parameter, valid body, and valid token")
    public void postAddVenueImageWithInvalidParameterValidBodyAndValidToken(String id) {
        File imageFile = new File(Constants.IMAGE_UPLOAD_REQUEST+"lapanganBola1.jpg");
        venuesAPI.postAddVenueImage(authorizationVenues.getTokenUserVenues(), id, imageFile);
    }

    //Negative Case 3
    @Given("Post add venue image with {string} blank parameter, blank body, and wrong token")
    public void postAddVenueImageWithBlankParameterBlankBodyAndWrongToken(String id) {
        venuesAPI.postAddVenueImageWithBlankBody(AuthorizationVenues.WRONG_TOKEN_VENUES, id);
    }
}
