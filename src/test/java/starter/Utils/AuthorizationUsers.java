package starter.Utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.PlaygroundPro.UsersAPI;

import java.io.File;

public class AuthorizationUsers {
    public String getTokenUser() {
        File jsonRequest = new File(Constants.REQ_BODY_DIR+"Login/LoginValidUser.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(UsersAPI.GET_USER_PROFIL);

        JsonPath jsonPathEvaluator = response.jsonPath();

        return jsonPathEvaluator.get(Constants.DATA_TOKEN);
    }

    public static String WRONG_TOKEN = "wrongToken";
}