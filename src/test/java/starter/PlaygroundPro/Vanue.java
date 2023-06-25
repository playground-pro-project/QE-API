package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

public class Vanue {
    static Token tokenUtils;

    public static String VANUES = Constants.BASE_URL + "/vanues";

    @Step("Get all vanues with valid query parameters")
    public static void getAllVanues(String email, String password) throws Exception {
        String token = tokenUtils.GetToken(email, password);

        SerenityRest.given().header("Authorization:", "bearer " + token).queryParam("limit",10).queryParam("page",1);

    }

    @Step("Get all vanues with valid query parameter")
    public static void getAllVanuesInvalidQueryParameter(String email, String password) throws Exception {
        String token = tokenUtils.GetToken(email, password);

        SerenityRest.given().header("Authorization:", "bearer " + token).queryParam("limit",10).queryParam("page","abc");

    }

    @Step("Get single vanues with valid vanues id")
    public static void getSingleVanues(String email, String password, int Id) throws Exception {
        String token = tokenUtils.GetToken(email, password);

        SerenityRest.given().header("Authorization:", "bearer " + token).pathParam("id",Id);
    }

    @Step("Get single vanues with invalid vanues id")
    public static void getSingleVanuesInvalidId(String email, String password, String Id) throws Exception {
        String token = tokenUtils.GetToken(email, password);

        SerenityRest.given().header("Authorization:", "bearer " + token).pathParam("id",Id);
    }

}
