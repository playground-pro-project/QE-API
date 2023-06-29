package starter.Utils.Venues;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.PlaygroundPro.VenuesAPI;
import starter.Utils.Constants;

import java.io.File;

public class AuthorizationVenues {
    public String getTokenUserVenues() {
        File jsonRequest = new File(Constants.REQ_BODY_DIR+"LoginUsers/LoginValidUserVenues.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(VenuesAPI.POST_LOGIN_USER_VENUES);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("data.token");
        return Constants.DATA_TOKENS = token;
//        return jsonPathEvaluator.get(Constants.DATA_TOKENS);
    }

    public static String WRONG_TOKEN_VENUES = "wrongToken";













}
