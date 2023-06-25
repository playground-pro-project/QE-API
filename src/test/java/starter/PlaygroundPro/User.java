package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;


public class User {
    static Token tokenUtils;
    public static String USER_RESERVATIONS = Constants.BASE_URL + "/user/reservations";

    @Step("Get users reservation with valid token")
    public static void getUserReservationValidToken(String email, String password) throws Exception {
        String token = tokenUtils.GetToken(email, password);

        SerenityRest.given().header("Authorization:", "bearer " + token);

    }

    @Step("Get users reservation with Invalid token")
    public static void getUserReservationInvalidToken() {

        SerenityRest.given().header("Authorization:", "bearer " + "");

    }

}