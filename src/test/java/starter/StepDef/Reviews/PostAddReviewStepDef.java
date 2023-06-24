package starter.StepDef.Reviews;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.ReviewsAPI;
import starter.Utils.Constants;
import starter.Utils.Reviews.AuthorizationReviews;

import java.io.File;

public class PostAddReviewStepDef {
    @Steps
    ReviewsAPI reviewsAPI;
    AuthorizationReviews authorizationReviews;

    //Positive Case 1
    @Given("Post add a review with valid token and valid body")
    public void postAddAReviewWithValidTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Reviews/PostReviewReviews.json");
        reviewsAPI.postReviewReviews(authorizationReviews.getTokenUserReviews(), json);
    }
    @When("Send request post add a review")
    public void sendRequestPostAddAReview() {
        SerenityRest.when().post(ReviewsAPI.POST_REVIEW_REVIEWS);
    }
    @And("Validate json schema post add a review")
    public void validateJsonSchemaPostAddAReview() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Reviews/PostReviewReviewsJsonSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Post add a review with wrong token and valid body")
    public void postAddAReviewWithWrongTokenAndValidBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Reviews/PostReviewReviews.json");
        reviewsAPI.postReviewReviews(AuthorizationReviews.WRONG_TOKEN_REVIEWS, json);
    }

    //Negative Case 2
    @Given("Post add a review with valid token and blank body")
    public void postAddAReviewWithValidTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Reviews/PostReviewBlankBody.json");
        reviewsAPI.postReviewReviews(authorizationReviews.getTokenUserReviews(), json);
    }

    //Negative Case 3
    @Given("Post add a review with blank token and blank body")
    public void postAddAReviewWithBlankTokenAndBlankBody() {
        File json = new File(Constants.REQ_BODY_DIR+"Reviews/PostReviewBlankBody.json");
        reviewsAPI.postReviewReviews(AuthorizationReviews.WRONG_TOKEN_REVIEWS, json);
    }
}
