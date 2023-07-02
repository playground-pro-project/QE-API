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

public class GetVenueByIdStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Get venue by id with valid {string} parameter and valid token")
    public void getVenueByIdWithValidParameterAndValidToken(String id) {
        venuesAPI.getVenueById(authorizationVenues.getTokenUserVenues(), id);
    }
    @When("Send request get venue by id")
    public void sendRequestGetVenueById() {
        SerenityRest.when().get(VenuesAPI.GET_VENUE_BY_ID);
    }
    @And("Validate json schema get venue by id with valid parameter")
    public void validateJsonSchemaGetVenueByIdWithValidParameter() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/GetVenueByIdJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get venue by id with valid {string} parameter and wrong token")
    public void getVenueByIdWithValidParameterAndWrongToken(String id) {
        venuesAPI.getVenueById(AuthorizationVenues.WRONG_TOKEN_VENUES, id);
    }

    //Negative Case 2
    @Given("Get venue by id with invalid {string} parameter and valid token")
    public void getVenueByIdWithInvalidParameterAndValidToken(String id) {
        venuesAPI.getVenueById(authorizationVenues.getTokenUserVenues(), id);
    }

    //Negative Case 3
    @Given("Get venue by id with invalid {string} parameter and blank token")
    public void getVenueByIdWithBlankParameterAndBlankToken(String id) {
        venuesAPI.getVenueById(AuthorizationVenues.WRONG_TOKEN_VENUES, id);
    }
}
