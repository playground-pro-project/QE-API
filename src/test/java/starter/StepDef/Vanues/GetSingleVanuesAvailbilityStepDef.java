package starter.StepDef.Vanues;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Vanues;
import starter.Utils.Constants;

import java.io.File;

public class GetSingleVanuesAvailbilityStepDef {
    @Steps
    static
    Vanues venues;

    @Given("Get single vanues availbility with valid parameter id {string}")
    public void getSingleVanuesWithValidParameterId(String id) throws Exception {
        venues.getSingleVanuesAvailbility(id);
    }

    @Given("Get single vanues availbility with invalid parameter id {string}")
    public static void getSingleVanuesWithInvalidParameterId(String id) throws Exception {
        Vanues.getSingleVanuesAvailbilitInvalidId(id);
    }
    @When("Send Get single vanues availbility")
    public static void sendGetSingleVanues() {

        Response response = SerenityRest.when().get(venues.VANUES_SINGLE);
        System.out.println(response.jsonPath().getString("message"));
    }

    @And("Validate Json Schema Get single Vanues availbility")
    public static void validateJsonSchema(){
        File json = new File(Constants.JSON_SCHEMA_DIR+"vanues/getVenuesAvailability.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
