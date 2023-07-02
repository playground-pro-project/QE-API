package starter.StepDef.Venues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Venues;
import starter.Utils.Constants;

import java.io.File;

public class PostAddVenueReviewStepDef {
    @Steps
    Venues venues;

    @Given("Post add venue review valid body with id {string}")
    public void postAddVenueReview(String id) throws Exception {
        File json = new File(Constants.REQ_BODY_DIR + "venue/postAddVenueReview.json");
        venues.postAddVenueReview(json, id);
    }
    @Given("Post add venue review invalid body with id {string}")
    public void postAddVenueReviewInvalidBody(String id) throws Exception {
        File json = new File(Constants.REQ_BODY_DIR + "venue/postAddVenueReviewInvalidBody.json");
        venues.postAddVenueReviewInvalidBody(json,id);
    }

    @When("Send post add venue review")
    public void SendPostAddVenueReview() {

        Response response = SerenityRest.when().post(Venues.VENUE_REVIEWS);
        System.out.println(response.jsonPath().getString("message"));
    }

    }


