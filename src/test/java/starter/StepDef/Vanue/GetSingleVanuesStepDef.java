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

public class GetSingleVanuesStepDef {
    @Steps
    static
    Vanue vanue;

    @Given("Get single vanues with valid parameter id {int} from credentials email {string} and password {string}")
    public void getSingleVanuesWithValidParameterId(String email, String password, int id) throws Exception {
        vanue.getSingleVanues(email, password, id);
    }

    @Given("Get single vanues with invalid parameter id {string} from credentials email {string} and password {string}")
    public static void getSingleVanuesWithInvalidParameterId(String email, String password, String id) throws Exception {
        Vanue.getSingleVanuesInvalidId(email, password, id);
    }
    @When("Send Get single vanues")
    public static void sendGetSingleVanues() {
        SerenityRest.when().get(vanue.VANUES);
    }

    @And("Validate Json Schema Get single Vanues")
    public static void validateJsonSchema(){
        File json = new File(Constants.JSON_SCHEMA_DIR+"getSingleVanues.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
