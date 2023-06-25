package starter.StepDef.Reservation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reservation;
import starter.Utils.Constants;

import java.io.File;

public class PostReservationStepDef {
    @Steps
    Reservation reservation;

    @Given("Post Create reservation with valid json reqbody and valid token from credential email {string} and password {string}")
    public void postCreateReservationValidBodyJson(String email, String password) throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"postReservationValidBody.json");
        reservation.postCreateReservation(email, password, json);
    }

    @Given("Post Create reservation with invalid json reqbody and valid token from credential email {string} and password {string}")
    public void postCreateReservationInvalidBodyJson(String email, String password) throws Exception{
        File json = new File(Constants.REQ_BODY_DIR+"postReservationInvalidBody.json");
        reservation.postCreateReservationInvalid(email, password, json);
    }

    @When("Send post Create reservation")
    public void sendPostCreateReservation() {
        SerenityRest.when().post(reservation.RESERVATION);
    }


    }

