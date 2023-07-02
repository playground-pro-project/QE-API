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
    public void postCreatePaymentWithValidReqbodyJson( File json) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);
        SerenityRest.given().header("Authorization:","Bearer "+token).contentType("application/Json").body(json);
    }

    @Step("Post create payment with invalid reqbody json")
    public void postCreatePaymentWithInvalidReqbodyJson(File json) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR+"token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);
        SerenityRest.given().header("Authorization:","Bearer "+token).contentType("application/Json").body(json);
    }
}
