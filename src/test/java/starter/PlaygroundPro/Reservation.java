package starter.PlaygroundPro;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

import java.io.File;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class Reservation {
    Token tokenUtils;

    public static String RESERVATION = Constants.BASE_URL + "/reservations";
    public static String RESERVATION_ID = Constants.BASE_URL + "/reservations/{id}";
    public static String paymentId;

    @Step("Post create reservation with valid reqbody json")
    public void postCreateReservation(File json) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);
        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(json);

    }

    @Step("Post create reservation with invalid reqbody json")
    public void postCreateReservationInvalid(File json) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(json);

    }

    @Step("Get single user reservation with valid id")
    public void getSingleReservationWithValidId() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "Bearer " + token).pathParam("id", paymentId);
    }

    @Step("Get single user reservation with invalid id")
    public void getSingleReservationWithInvalidId() throws Exception {

        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "Bearer " + token).pathParam("id", "a");
    }
}