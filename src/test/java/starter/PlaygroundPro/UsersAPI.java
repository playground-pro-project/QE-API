package starter.PlaygroundPro;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class UsersAPI {
    public static String GET_USER_PROFIL = Constants.BASE_URL+"/users";
    public static String GET_USER_PROFIL_INVALID = Constants.BASE_URL+"/users1";
    public static String POST_REGISTER_USER_USERS = Constants.BASE_URL+"/register";
    public static String POST_LOGIN_USER_USERS = Constants.BASE_URL+"/login";
    public static String DELETE_USER_USERS = Constants.BASE_URL+"/users";
    public static String PUT_CHANGE_USER_PASSWORD_USERS = Constants.BASE_URL+"/users/password";
    public static String PUT_UPDATE_USER_PROFIL_USERS = Constants.BASE_URL+"/users";
    public static String PUT_CHANGE_PROFIL_PICTURE_USERS = Constants.BASE_URL+"/users/profile/picture";

    //GET USER PROFIL
    @Step("Get user profil with valid path")
    public void getUserProfilUsers(String token) {
        SerenityRest.given()
                    .header("Authorization", "Bearer " + token);
    }

    //POST REGIST USER
    @Step("Add user with string json")
    public void postUserUsers(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //DELETE USER
    @Step("Delete user with wrong token")
    public void deleteUserUsers(String token) {
        SerenityRest.given()
                    .header("Authorization", "Bearer " + token);
    }
    @Step("Delete user without token")
    public void deleteUserWithoutTokenUsers() {
        SerenityRest.given();
    }

    //PUT CHANGE PASSWORD
    @Step("Put change user password")
    public void putChangeUserPasswordUsers(String token, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //PUT UPDATE USER PROFIL
    @Step("Put update user profil")
    public void putUpdateUserProfil(String token, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //PUT CHANGE PROFIL PICTURE
    @Step("Put change user profil picture")
    public void putChangeProfilPictureUsers(String token, File imageFile) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART_FORM_DATA)
                .multiPart("profile_picture", imageFile);
    }
    @Step("Put change user profil with blank body")
    public void putChangeProfilPictureWithBlankBody(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

}
