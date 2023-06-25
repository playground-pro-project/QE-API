package starter.StepDef.Reservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reservation;
import starter.Utils.Constants;

import java.io.File;

public class PutReservationStepDef {
    @Steps
    Reservation reservation;

    @Given("Put update reservation with valid json reqbody and valid id {string} also token from credential email {string} and password {string}")
    public void putUpdateResevationValid(String id, String email, String password) throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"putReservationValidBody.json");
        reservation.putUpdateReservation(email, password, id, json);
    }

    @Given("Put update reservation with invalid json reqbody and valid id {string} also token from credential email {string} and password {string}")
    public void putUpdateResevationInvalid(String id, String email, String password) throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"putReservationInvalidBody.json");
        reservation.putUpdateReservationInvalid(email, password, id, json);
    }

    @Given("Put update reservation without json reqbody and valid id {string} also token from credential email {string} and password {string}")
    public void putUpdateResevationInvalidId(String id, String email, String password) throws Exception{
        reservation.putUpdateReservationWithoutReqbody(email, password, id);
    }

    @When("Send put update reservation")
    public void sendPutUpdateReservation() {
        SerenityRest.when().put(reservation.RESERVATION_ID);
    }
}
