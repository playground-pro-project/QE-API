package starter.Utils.Reviews;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.PlaygroundPro.ReviewsAPI;
import starter.Utils.Constants;

import java.io.File;

public class AuthorizationReviews {
    public String getTokenUserReviews() {
        File jsonRequest = new File(Constants.REQ_BODY_DIR+"Reviews/LoginValidUserReviews.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(ReviewsAPI.DELETE_REVIEW_REVIEWS);

        JsonPath jsonPathEvaluator = response.jsonPath();

        return jsonPathEvaluator.get(Constants.DATA_TOKENS);
    }

    public static String WRONG_TOKEN_REVIEWS = "wrongToken";










}
