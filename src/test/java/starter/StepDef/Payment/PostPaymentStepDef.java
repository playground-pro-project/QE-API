package starter.StepDef.Payment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.Payment;
import starter.Utils.Constants;

import java.io.File;


public class PostPaymentStepDef {
    @Steps
    Payment payment;

    @Given("Post Create payment with valid json reqbody and valid token from credential email {string} and password {string}")
    public void postPaymentValidBodyJson(String email, String password) throws Exception {
        File json = new File(Constants.REQ_BODY_DIR+"postPaymentValidBody.json");
        payment.postCreatePaymentWithValidReqbodyJson(email, password, json);
    }

    @Given("Post Create payment with invalid json reqbody and valid token from credential email {string} and password {string}")
    public void postPaymentInvalidBodyJson(String email, String password) throws Exception {
        File json = new File(Constants.REQ_BODY_DIR+"postPaymentInvalidBody.json");
        payment.postCreatePaymentWithValidReqbodyJson(email, password, json);
    }
    @When("Send post create payment")
    public void sendPostCreatePayment() {
        SerenityRest.when().post(payment.PAYMENTS);
    }
}
