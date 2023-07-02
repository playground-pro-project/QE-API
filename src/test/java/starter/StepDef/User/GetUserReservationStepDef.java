package starter.StepDef.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.User;
import starter.Utils.Constants;

import java.io.File;

public class GetUserReservationStepDef {
    @Steps
    static
    User user;

    @Given("Get users reservation with valid token")
    public static void getUserReservation() throws Exception {
        User.getUserReservationValidToken();
    }

    @Given("Get users reservation with invalid token")
    public static void getUserReservationWithInvalidToken()  {
        User.getUserReservationInvalidToken();
    }

    @Given("Get users reservation has not reservation")
    public static void getUserReservationHasNotReservation() throws Exception {User.getUserReservationHasNotReservation();}

    @When("Send get users reservation")
    public static void sendGetUserReservation() {

        Response response = SerenityRest.when().get(User.USER_RESERVATIONS);
        System.out.println(response.jsonPath().getString("message"));
    }

    @And("Validate json schema get users reservation")
    public void validateJsonSchema(){
        File json = new File(Constants.JSON_SCHEMA_DIR+"getUserSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
