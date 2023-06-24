package starter.PlaygroundPro;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReviewsAPI {
    public static String DELETE_REVIEW_REVIEWS = Constants.BASE_URL+"/reviews/{review_id}";
    public static String POST_REVIEW_REVIEWS = Constants.BASE_URL+"/reviews";



    @Step("Delete review with valid/invalid parameter")
    public void deleteReviewReviews(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("review_id", id);
    }

    @Step("Post review with valid/invalid body json")
    public void postReviewReviews(String token, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }








}
