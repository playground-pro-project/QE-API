package starter.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class getReviews {

    public String getReviews(String token) {
        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "bearer " + token)
                .get("/venues/VNE-NDA0A2CF/reviews");

        System.out.println("message:"+response.jsonPath().getString("message"));

        return response.jsonPath().getString("data[0].review_id");
    }
}
