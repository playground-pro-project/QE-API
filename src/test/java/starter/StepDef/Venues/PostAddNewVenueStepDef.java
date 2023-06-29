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
import starter.Utils.Users.AuthorizationUsers;
import starter.Utils.Venues.AuthorizationVenues;

import java.io.File;

public class PostAddNewVenueStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Post add new venue with valid token and valid body")
    public void postAddNewVenueWithValidTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PostAddNewVenue.json");
        venuesAPI.postAddNewVenue(authorizationVenues.getTokenUserVenues(), json);
    }
    @When("Send request post add new venue")
    public void sendRequestPostAddNewVenue() {
        SerenityRest.when().post(VenuesAPI.POST_ADD_NEW_VENUE_VENUES);
    }
    @And("Validate json schema post add new venue")
    public void validateJsonSchemaPostAddNewVenue() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Venues/PostAddNewVenueJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Post add new venue with wrong token and valid body")
    public void postAddNewVenueWithWrongTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Venues/PostAddNewVenue.json");
        venuesAPI.postAddNewVenue(AuthorizationVenues.WRONG_TOKEN_VENUES, json);
    }

    //Negative Case 2
    @Given("Post add new venue with valid token and blank body")
    public void postAddNewVenueWithValidTokenAndBlankBody() {
        venuesAPI.postAddNewVenueWithBlankBody(authorizationVenues.getTokenUserVenues());
    }

    //Negative Case 3
    @Given("Post add new venue with blank token and blank body")
    public void postAddNewVenueWithBlankTokenAndBlankBody() {
        venuesAPI.postAddNewVenueWithBlankBody(AuthorizationVenues.WRONG_TOKEN_VENUES);
    }
}
