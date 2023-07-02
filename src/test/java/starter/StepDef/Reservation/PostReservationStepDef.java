package starter.StepDef.Reservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reservation;
import starter.Utils.Constants;

import java.io.File;

public class PostReservationStepDef {
    @Steps
    Reservation reservation;

    @Given("Post Create reservation with valid json reqbody")
    public void postCreateReservationValidBodyJson() throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"reservation/postReservationValidBody.json");
        reservation.postCreateReservation(json);
    }

    @Given("Post Create reservation with invalid json reqbody")
    public void postCreateReservationInvalidBodyJson() throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"reservation/postReservationInvalidBody.json");
        reservation.postCreateReservationInvalid(json);
    }

    @When("Send post Create reservation")
    public void sendPostCreateReservation() {

        Response response = SerenityRest.when().post(reservation.RESERVATION);
        System.out.println(response.jsonPath().getString("message"));
        if (response.statusCode() == 201) {
            Reservation.paymentId = response.jsonPath().getString("data.payment_id");
        }

    }
    }

