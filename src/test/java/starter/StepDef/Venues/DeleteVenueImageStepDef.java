package starter.StepDef.Venues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.VenuesAPI;
import starter.Utils.Venues.AuthorizationVenues;

public class DeleteVenueImageStepDef {
    @Steps
    VenuesAPI venuesAPI;
    AuthorizationVenues authorizationVenues = new AuthorizationVenues();

    //Positive Case 1
    @Given("Delete venue image with valid {string} parameter venue_id, valid {string} parameter image_id, and valid token")
    public void deleteVenueImageWithValidParameterVenue_idValidParameterImage_idAndValidToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(authorizationVenues.getTokenUserVenues(), venue_id, image_id);
    }
    @When("Send request delete venue image")
    public void sendRequestDeleteVenueImage() {
        SerenityRest.when().delete(VenuesAPI.DELETE_VENUE_IMAGE);
    }

    //Negative Case 1
    @Given("Delete venue image with valid {string} parameter venue_id, valid {string} parameter image_id, and wrong token")
    public void deleteVenueImageWithValidParameterVenue_idValidParameterImage_idAndWrongToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(AuthorizationVenues.WRONG_TOKEN_VENUES, venue_id, image_id);
    }

    //Negative Case 2
    @Given("Delete venue image with invalid {string} parameter venue_id, valid {string} parameter image_id, and valid token")
    public void deleteVenueImageWithInvalidParameterVenue_idValidParameterImage_idAndValidToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(authorizationVenues.getTokenUserVenues(), venue_id, image_id);
    }

    //Negative Case 3
    @Given("Delete venue image with valid {string} parameter venue_id, invalid {string} parameter image_id, and valid token")
    public void deleteVenueImageWithValidParameterVenue_idInvalidParameterImage_idAndValidToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(authorizationVenues.getTokenUserVenues(), venue_id, image_id);
    }

    //Negative Case 4
    @Given("Delete venue image with invalid {string} parameter venue_id, valid {string} parameter image_id, and wrong token")
    public void deleteVenueImageWithInvalidParameterVenue_idValidParameterImage_idAndWrongToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(AuthorizationVenues.WRONG_TOKEN_VENUES, venue_id, image_id);
    }

    //Negative Case 5
    @Given("Delete venue image with invalid {string} parameter venue_id, invalid {string} parameter image_id, and wrong token")
    public void deleteVenueImageWithInvalidParameterVenue_idInvalidParameterImage_idAndWrongToken(String venue_id, String image_id) {
        venuesAPI.deleteVenueImage(AuthorizationVenues.WRONG_TOKEN_VENUES, venue_id, image_id);
    }
}
