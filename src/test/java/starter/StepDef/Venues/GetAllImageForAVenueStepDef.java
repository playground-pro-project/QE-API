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

public class GetAllImageForAVenueStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Get all images for a venue with valid {string} parameter and valid token")
    public void getAllImagesForAVenueWithValidParameterAndValidToken(String id) {
        venuesAPI.getAllImageForAVenue(authorizationVenues.getTokenUserVenues(), id);
    }
    @When("Send request get all images for a venue")
    public void sendRequestGetAllImagesForAVenue() {
        SerenityRest.when().get(VenuesAPI.GET_ALL_IMAGE_FOR_A_VENUE);
    }
    @And("Validate json schema get all images for a venue")
    public void validateJsonSchemaGetAllImagesForAVenue() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/GetAllImageForAVenueJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get all images for a venue with valid {string} parameter and wrong token")
    public void getAllImagesForAVenueWithValidParameterAndWrongToken(String id) {
        venuesAPI.getAllImageForAVenue(AuthorizationVenues.WRONG_TOKEN_VENUES,id);
    }

    //Negative Case 2
    @Given("Get all images for a venue with invalid {string} parameter and valid token")
    public void getAllImagesForAVenueWithInvalidParameterAndValidToken(String id) {
        venuesAPI.getAllImageForAVenue(authorizationVenues.getTokenUserVenues(), id);
    }

    //Negative Case 3
    @Given("Get all images for a venue with invalid {string} parameter and blank token")
    public void getAllImagesForAVenueWithInvalidParameterAndBlankToken(String id) {
        venuesAPI.getAllImageForAVenue(AuthorizationVenues.WRONG_TOKEN_VENUES,id);
    }
}
