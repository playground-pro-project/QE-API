package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

import java.io.File;

public class Payment {
    Token tokenUtils;

    public static String PAYMENTS = Constants.BASE_URL + "/payments";

    @Step("Post create payment with valid reqbody json")
    public void postCreatePaymentWithValidReqbodyJson(String email, String Password, File json) throws Exception{
        String  token = tokenUtils.GetToken(email, Password);
        SerenityRest.given().header("Authorization:","Bearer "+token).contentType("application/Json").body(json);
    }

    @Step("Post create payment with invalid reqbody json")
    public void postCreatePaymentWithInvalidReqbodyJson(String email, String Password, File json) throws Exception {
        String  token = tokenUtils.GetToken(email, Password);
        SerenityRest.given().header("Authorization:","Bearer "+token).contentType("application/Json").body(json);
    }
}
