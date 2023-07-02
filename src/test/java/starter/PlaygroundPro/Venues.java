package starter.PlaygroundPro;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;
import starter.Utils.Token;

import java.io.File;

public class Venues {
    static Token tokenUtils;
    public static String VANUES = Constants.BASE_URL + "/venues";
    public static String VANUES_SINGLE = Constants.BASE_URL + "/venues/{id}/availability";
    public static String VENUE_REVIEWS = Constants.BASE_URL + "/venues/{id}/reviews";

    @Step("Get single vanues availability")
    public static void getSingleVanuesAvailbility(String Id) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenGetUserVenues.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token).pathParam("id", Id);
    }

    @Step("Get single vanues availability with invalid vanues id")
    public static void getSingleVanuesAvailbilitInvalidId(String Id) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token).pathParam("id", Id);
    }

    @Step("Post add venue review with invalid vanue id")
    public static void postAddVenueReview(File json, String id) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().pathParam("id", id)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json").body(json);
    }

    @Step("Post add venue review invalid body json vanue id")
    public static void postAddVenueReviewInvalidBody(File json, String id) throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().pathParam("id", id)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json").body(json);

    }

    @Step("Get all venues with valid query parameters")
    public static void getAllVanues() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token).queryParam("limit", 6).queryParam("page", 1);

    }

    @Step("Get all venues with invalid query parameter")
    public static void getAllVanuesInvalidQueryParameter() throws Exception {
        File jsonTOken = new File(Constants.REQ_BODY_DIR + "token/tokenDerin.json");
        String token = tokenUtils.GetToken(jsonTOken);

        SerenityRest.given().header("Authorization", "bearer " + token).queryParam("limit", 10).queryParam("page", 10);

    }
}