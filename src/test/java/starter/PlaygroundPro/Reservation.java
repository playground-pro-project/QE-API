package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

import java.io.File;

public class Reservation {
    Token tokenUtils;

    public static String RESERVATION = Constants.BASE_URL + "/reservations";
    public static String RESERVATION_ID = Constants.BASE_URL + "/reservations/{id}";

    @Step("Post create reservation with valid reqbody json")
    public void postCreateReservation(String email, String Password, File json) throws Exception {
        String token = tokenUtils.GetToken(email, Password);

        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").body(json);

    }

    @Step("Post create reservation with invalid reqbody json")
    public void postCreateReservationInvalid(String email, String Password, File json) throws Exception {
        String token = tokenUtils.GetToken(email, Password);

        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").body(json);

    }

    @Step("Put Update reservation with valid parameter id and valid reqbody")
    public void putUpdateReservation(String email, String Password,String id,File json) throws Exception {
        String token = tokenUtils.GetToken(email, Password);

        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").pathParam("id",id).body(json);

    }

    @Step("Put Update reservation with invalid parameter id and valid reqbody")
    public void putUpdateReservationInvalid(String email, String Password,String id,File json) throws Exception {
        String token = tokenUtils.GetToken(email, Password);

        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").pathParam("id",id).body(json);

    }

    @Step("Put Update reservation with valid parameter id and without reqbody")
    public void putUpdateReservationWithoutReqbody(String email, String Password,String id) throws Exception {
        String token = tokenUtils.GetToken(email, Password);

        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").pathParam("id",id);

    }


    @Step("Delete reservation with valid parameter id")
    public void deleteReservation(String email, String Password,String id) throws Exception {
        String token = tokenUtils.GetToken(email, Password);
        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").pathParam("id",id);
    }

    @Step("Delete reservation with invalid parameter id")
    public void deleteReservationInvalid(String email, String Password,String id) throws Exception {
        String token = tokenUtils.GetToken(email, Password);
        SerenityRest.given().header("Authorization:", "Bearer " + token).contentType("application/json").pathParam("id",id);
    }
}