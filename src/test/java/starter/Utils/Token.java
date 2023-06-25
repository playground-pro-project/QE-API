package starter.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Token {
    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String GetToken(String email, String password) throws Exception {
        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType("multipart/form-data")
                .multiPart("email", email)
                .multiPart("password", password)
                .post(LOGIN);

        return response.jsonPath().getString("data.token");
    }

}
