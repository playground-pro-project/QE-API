package starter.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class Token {
    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String GetToken(File json) throws Exception {
        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON).body(json).post(LOGIN);

        return response.jsonPath().getString("data.token");
    }

}
