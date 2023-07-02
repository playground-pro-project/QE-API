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

public class GetAllReviewsForAVenueStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Get all reviews for a venue with valid {string} parameter and valid token")
    public void getAllReviewsForAVenueWithValidParameterAndValidToken(String id) {
        venuesAPI.getAllReviewsForAVenue(authorizationVenues.getTokenUserVenues(), id);
    }
    @When("Send request get all reviews for a venue")
    public void sendRequestGetAllReviewsForAVenue() {
        SerenityRest.when().get(VenuesAPI.GET_ALL_REVIEWS_FOR_A_VENUE);
    }
    @And("Validate json schema get all reviews for a venue with valid parameter and valid token")
    public void validateJsonSchemaGetAllReviewsForAVenueWithValidParameterAndValidToken() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/GetAllReviewsForAVenueJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get all reviews for a venue with valid {string} parameter and wrong token")
    public void getAllReviewsForAVenueWithValidParameterAndWrongToken(String id) {
        venuesAPI.getAllReviewsForAVenue(AuthorizationVenues.WRONG_TOKEN_VENUES,id);
    }

    //Negative Case 2
    @Given("Get all reviews for a venue with invalid {string} parameter and valid token")
    public void getAllReviewsForAVenueWithInvalidParameterAndValidToken(String id) {
        venuesAPI.getAllReviewsForAVenue(authorizationVenues.getTokenUserVenues(), id);
    }

    //Negative Case 3
    @Given("Get all reviews for a venue with invalid {string} parameter and blank token")
    public void getAllReviewsForAVenueWithInvalidParameterAndBlankToken(String id) {
        venuesAPI.getAllReviewsForAVenue(AuthorizationVenues.WRONG_TOKEN_VENUES,id);
    }
}
