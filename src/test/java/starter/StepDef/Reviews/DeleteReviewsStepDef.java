package starter.StepDef.Reviews;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reviews;

public class DeleteReviewsStepDef {
    @Steps
    static
    Reviews review;

    @Given("Delete review with valid id")
    public void deleteReviewWithValidId() throws Exception {
        Reviews.DeleteReviewsValidId();
    }

    @Given("Delete review with invalid id")
    public void deleteReviewWithInvalidId() throws Exception {
        Reviews.DeleteReviewsInvalidId();
    }

    @When("Send delete reviews")
    public void sendDeleteReviews() {

        Response response = SerenityRest.when().delete(Reviews.REVIEWS);

        System.out.println(response.jsonPath().getString("message"));
    }
}



