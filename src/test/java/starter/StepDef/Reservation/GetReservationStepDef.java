package starter.StepDef.Reservation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reservation;
import starter.Utils.Constants;

import java.io.File;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class GetReservationStepDef {
    @Steps
    Reservation reservation;


    @Given("Get single user reservation with valid id")
    public void getReservationWithValidId() throws Exception {;
        reservation.getSingleReservationWithValidId();
    }

    @Given("Get single user reservation with invalid id")
    public void getReservationWithInvalidId() throws Exception {
        reservation.getSingleReservationWithInvalidId();
    }

    @When("Send get single user reservation")
    public void sendGetSingleUserReservation() {

       Response response = SerenityRest.when().get(Reservation.RESERVATION_ID);
        System.out.println(response.jsonPath().getString("message"));
    }

    @And("Validate Json Schema Get single user reservation")
    public void validateJsonSchemaGetSingleUserReservation() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"reservation/getSingleUserReservationInvalidId.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
