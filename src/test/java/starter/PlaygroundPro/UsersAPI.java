package starter.PlaygroundPro;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class UsersAPI {
    public static String GET_USER_PROFIL = Constants.BASE_URL+"/users";
    public static String GET_USER_PROFIL_INVALID = Constants.BASE_URL+"/users1";
    public static String POST_REGISTER_USER_USERS = Constants.BASE_URL+"/register";
    public static String POST_LOGIN_USER_USERS = Constants.BASE_URL+"/login";
    public static String DELETE_USER_USERS = Constants.BASE_URL+"/users";

    @Step("Get user profil with valid path")
    public void getUserProfilUsers(String token) {
        SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.TEXT);
    }

    @Step("Add user with string json")
    public void postUserUsers(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with wrong token")
    public void deleteUserUsers(String token) {
        SerenityRest.given()
                    .header("Authorization", "Bearer " + token);
    }

    @Step("Delete user without token")
    public void deleteUserWithoutTokenUsers() {
        SerenityRest.given();
    }
}
