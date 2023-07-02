package starter.PlaygroundPro;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;
import starter.Utils.getReviews;

import java.io.File;

public class Reviews {
    static Token tokenUtils;

    public static String REVIEWS = Constants.BASE_URL + "/reviews/{id}";

    @Step("Delete reviews with valid id")
    public static void DeleteReviewsValidId() throws Exception {

        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "bearer " + token)
                .get("/venues/VNE-NDA0A2CF/reviews");

        System.out.println("message:"+response.jsonPath().getString("data[0].review_id"));
        ;

        SerenityRest.given().header("Authorization", "bearer " + token).pathParam("id", response.jsonPath().getString("data[0].review_id"));
    }

    @Step("Delete reviews with invalid id")
    public static void DeleteReviewsInvalidId() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token).pathParam("id", "1234567890");
    }
}