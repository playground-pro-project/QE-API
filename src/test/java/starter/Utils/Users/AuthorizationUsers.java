package starter.Utils.Users;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.PlaygroundPro.UsersAPI;
import starter.Utils.Constants;

import java.io.File;

public class AuthorizationUsers {
    public String getTokenUserUsers() {
        File jsonRequest = new File(Constants.REQ_BODY_DIR+"LoginUsers/LoginValidUser.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(UsersAPI.POST_LOGIN_USER_USERS);

        JsonPath jsonPathEvaluator = response.jsonPath();

        return jsonPathEvaluator.get(Constants.DATA_TOKENS);
    }

    public static String WRONG_TOKEN = "wrongToken";

    public String getTokenByCustomUsers(String json) {
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(UsersAPI.POST_LOGIN_USER_USERS);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String token =jsonPathEvaluator.get(Constants.DATA_TOKENS);
        System.out.println("token ini " + token);
        return jsonPathEvaluator.get(Constants.DATA_TOKENS);
    };
}
