package starter.StepDef.Venues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.VenuesAPI;
import starter.Utils.Venues.AuthorizationVenues;

public class DeleteVenueStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Delete venue with {string} valid parameter and valid token")
    public void deleteVenueWithValidParameterAndValidToken(String id) {
        venuesAPI.deleteVenue(authorizationVenues.getTokenUserVenues(), id);
    }
    @When("Send request delete venue")
    public void sendRequestDeleteVenue() {
        SerenityRest.when().delete(VenuesAPI.DELETE_VENUE_VENUES);
    }

    //Negative Case 1
    @Given("Delete venue with {string} valid parameter and wrong token")
    public void deleteVenueWithValidParameterAndWrongToken(String id) {
        venuesAPI.deleteVenue(AuthorizationVenues.WRONG_TOKEN_VENUES, id);
    }

    //Negative Case 2
    @Given("Delete venue with {string} invalid parameter and valid token")
    public void deleteVenueWithInvalidParameterAndValidToken(String id) {
        venuesAPI.deleteVenue(authorizationVenues.getTokenUserVenues(), id);
    }

    //Negative Case 3
    @Given("Delete venue with {string} blank parameter and wrong token")
    public void deleteVenueWithBlankParameterAndWrongToken(String id) {
        venuesAPI.deleteVenue(AuthorizationVenues.WRONG_TOKEN_VENUES, id);
    }
}
