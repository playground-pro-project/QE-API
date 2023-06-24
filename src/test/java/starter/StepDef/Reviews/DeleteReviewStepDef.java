package starter.StepDef.Reviews;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.ReviewsAPI;
import starter.Utils.Reviews.AuthorizationReviews;

public class DeleteReviewStepDef {
    @Steps
    ReviewsAPI reviewsAPI;
    AuthorizationReviews authorizationReviews;

    //Positive Case 1
    @Given("Delete a review with {string} as id and valid token")
    public void deleteAReviewWithValidParameterAndValidToken(String id) {
        reviewsAPI.deleteReviewReviews(id, authorizationReviews.getTokenUserReviews());
    }
    @When("Send request delete a review")
    public void sendRequestDeleteAReview() {
        SerenityRest.when().delete(ReviewsAPI.DELETE_REVIEW_REVIEWS);
    }

    //Negative Case 1
    @Given("Delete a review with {string} as id and wrong token")
    public void deleteAReviewWithValidParameterAndWrongToken(String id) {
        reviewsAPI.deleteReviewReviews(id, AuthorizationReviews.WRONG_TOKEN_REVIEWS);
    }

    //Negative Case 2
    @Given("Delete a review with {string} as id")
    public void deleteAReviewWithInvalidParameter(String id) {
        reviewsAPI.deleteReviewReviews(id, AuthorizationReviews.WRONG_TOKEN_REVIEWS);
    }

    //Negative Case 3
    @Given("Delete a review with {string}")
    public void deleteAReviewWithBlankParameter(String id) {
        reviewsAPI.deleteReviewReviews(id, AuthorizationReviews.WRONG_TOKEN_REVIEWS);
    }
}
