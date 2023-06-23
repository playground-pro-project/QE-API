package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class UsersAPI {
    public static String GET_USER_PROFIL = Constants.BASE_URL+"/users";




    @Step("Get user profil with valid path")
    public void getUserProfil(String token) {
        SerenityRest.given().header("Authorization","Bearer" + token);
    }
    @Step("Get user profil with invalid path")
    public void getUserProfilInvalidPath() {
        SerenityRest.given();
    }
    @Step("Get user profil with valid path and wrong token")
    public void getUserProfil() {
        SerenityRest.given();
    }




}
