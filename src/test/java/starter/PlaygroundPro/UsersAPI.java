package starter.PlaygroundPro;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class UsersAPI {
    public static String GET_USER_PROFIL = Constants.BASE_URL+"/users";
    public static String GET_USER_PROFIL_INVALID = Constants.BASE_URL+"/users1";

    @Step("Get user profil with valid path")
    public void getUserProfil(String token) {
        SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.TEXT);
    }

}
