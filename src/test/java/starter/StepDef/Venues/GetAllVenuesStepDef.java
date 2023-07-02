package starter.StepDef.Venues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Venues;

public class GetAllVenuesStepDef {
    @Steps
    static
    Venues vanue;

    @Given("Get all venues with valid token")
    public static void getAllVanues() throws Exception {
        vanue.getAllVanues();
    }

    @Given("Get all venues with invalid query parameters")
    public static void getAllVanuesInvalid() throws Exception {
        vanue.getAllVanuesInvalidQueryParameter();
    }

    @When("Send Get All Vanues")
        public void sendGetAllVanues () {

        Response response = SerenityRest.when().get(vanue.VANUES);
        System.out.println(response.jsonPath().getString("message"));
        }

    }

