package starter.StepDef.Reservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Reservation;

public class DeleteReservationsStepDef {
    @Steps
    Reservation reservation;


    @Given("Delete reservation with valid id {string} with valid token from credential email {string} and password {string}")
    public void deleteReservationWithId(String email, String password,String id) throws Exception {
        reservation.deleteReservation(email, password, id);
    }

    @Given("Delete reservation with invalid id {string} with valid token from credential email {string} and password {string}")
    public void deleteReservationWithInvalidId(String email, String password,String id) throws Exception {
        reservation.deleteReservation(email, password, id);
    }

    @When("Send delete reservation")
    public void sendDeleteReservation() {
        SerenityRest.when().delete(reservation.RESERVATION_ID);
    }
}
