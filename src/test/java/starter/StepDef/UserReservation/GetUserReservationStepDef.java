package starter.StepDef.UserReservation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.User;
import starter.Utils.Constants;

import java.io.File;

public class GetUserReservationStepDef {
    @Steps
    static
    User user;

    @Given("Get users reservation with valid token from credential email {string} password {string}")
    public static void getUserReservation(String email, String password) throws Exception {
        User.getUserReservationValidToken(email, password);
    }

    @Given("Get users reservation with invalid token")
    public static void getUserReservationWithInvalidToken()  {
        User.getUserReservationInvalidToken();
    }

    @When("Send get users reservation")
    public static void sendGetUserReservation() {
        SerenityRest.when().get(User.USER_RESERVATIONS);
    }

    @And("Validate json schema get users reservation")
    public void validateJsonSchema(){
        File json = new File(Constants.JSON_SCHEMA_DIR+"getUserSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
