package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

import java.io.File;


public class User {
    static Token tokenUtils;
    public static String USER_RESERVATIONS = Constants.BASE_URL + "/users/reservations";
    public static String USER_VENUES = Constants.BASE_URL + "/users/venues";

    @Step("Get users reservation with valid token")
    public static void getUserReservationValidToken() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token);

    }

    @Step("Get users reservation has not reservation")
    public static void getUserReservationHasNotReservation() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenUserHasNotReservation.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token);

    }

    @Step("Get users reservation with Invalid token")
    public static void getUserReservationInvalidToken() {

        SerenityRest.given().header("Authorization", "bearer " + "");

    }

    @Step("Get users venues with valid token")
    public static void getUserVenuesValidToken() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenGetUserVenues.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token);

    }

    @Step("Get users venues with invalid token")
    public static void getUserVenuesInvalidToken() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenGetUserVenues.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token+"a");

    }
}