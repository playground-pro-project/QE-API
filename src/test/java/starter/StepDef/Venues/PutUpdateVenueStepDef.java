package starter.StepDef.Venues;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.UsersAPI;
import starter.PlaygroundPro.VenuesAPI;
import starter.Utils.Constants;
import starter.Utils.Venues.AuthorizationVenues;

import java.io.File;

public class PutUpdateVenueStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Put update venue with {string} valid parameter, valid body, and valid token")
    public void putUpdateVenueWithValidParameterValidBodyAndValidToken(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PutUpdateValidVenue.json");
        venuesAPI.putUpdateVenue(authorizationVenues.getTokenUserVenues(), id, json);
    }
    @When("Send request put update venue")
    public void sendRequestPutUpdateVenue() {
        SerenityRest.when().put(VenuesAPI.PUT_UPDATE_VENUE);
    }
    @And("Validate json schema update venue with valid parameter, valid body, and valid token")
    public void validateJsonSchemaUpdateVenueWithValidParameterValidBodyAndValidToken() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/PutUpdateVenueJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Put update venue with {string} valid parameter, valid body, and wrong token")
    public void putUpdateVenueWithValidParameterValidBodyAndWrongToken(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PutUpdateValidVenue.json");
        venuesAPI.putUpdateVenue(AuthorizationVenues.WRONG_TOKEN_VENUES, id, json);
    }

    //Negative Case 2
    @Given("Put update venue with {string} invalid parameter, valid body, and valid token")
    public void putUpdateVenueWithInvalidParameterValidBodyAndValidToken(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PutUpdateValidVenue.json");
        venuesAPI.putUpdateVenue(authorizationVenues.getTokenUserVenues(), id, json);
    }

    //Negative Case 3
    @Given("Put update venue with {string} valid parameter, blank body, and wrong token")
    public void putUpdateVenueWithValidParameterBlankBodyAndValidToken(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PutUpdateBlankVenue.json");
        venuesAPI.putUpdateVenue(AuthorizationVenues.WRONG_TOKEN_VENUES, id, json);
    }

}
