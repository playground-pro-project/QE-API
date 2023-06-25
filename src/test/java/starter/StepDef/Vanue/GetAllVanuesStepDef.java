package starter.StepDef.Vanue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Vanue;
import starter.Utils.Constants;

import java.io.File;

public class GetAllVanuesStepDef {
    @Steps
    static
    Vanue vanue;

    @Given("Get all vanues with valid token from credential email {string} password {string} and valid query parameters")
    public static void getAllVanues(String email, String password) throws Exception {
        vanue.getAllVanues(email, password);
    }

    @Given("Get all vanues with valid token from credential email {string} password {string} and invalid query parameters")
    public static void getAllVanuesInvalid(String email, String password) throws Exception {
        vanue.getAllVanuesInvalidQueryParameter(email, password);
    }

        @And("Validate Json Schema Get All Vanues")
        public void validateJsonSchemaGetAllVanues () {
            File json = new File(Constants.JSON_SCHEMA_DIR + "getAllUserSchema.json");
            SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
        }

        @When("Send Get All Vanues")
        public void sendGetAllVanues () {
            SerenityRest.when().get(vanue.VANUES);
        }

    }

