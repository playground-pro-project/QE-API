package starter.PlaygroundPro;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class VenuesAPI {
    public static String POST_LOGIN_USER_VENUES = Constants.BASE_URL+"/login";
    public static String POST_ADD_NEW_VENUE_VENUES = Constants.BASE_URL+"/venues";
    public static String GET_VENUE_BY_ID = Constants.BASE_URL+"/venues/{venue_id}";
    public static String PUT_UPDATE_VENUE = Constants.BASE_URL+"/venues/{venue_id}";
    public static String DELETE_VENUE_VENUES = Constants.BASE_URL+"/venues/{venue_id}";
    public static String POST_ADD_VENUE_IMAGES = Constants.BASE_URL+"/venues/{venue_id}/images";
    public static String GET_ALL_IMAGE_FOR_A_VENUE = Constants.BASE_URL+"/venues/{venue_id}/images";
    public static String GET_ALL_REVIEWS_FOR_A_VENUE = Constants.BASE_URL+"/venues/{venue_id}/reviews";
    public static String DELETE_VENUE_IMAGE = Constants.BASE_URL+"/venues/{venue_id}/images/{image_id}";





    //POST ADD NEW VENUE
    @Step("Post add new venue with valid/invalid json")
    public void postAddNewVenue(String token, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post add new venue with without body json")
    public void postAddNewVenueWithBlankBody(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    //GET VENUE BY ID
    @Step("Get venue by valid/invalid id")
    public void getVenueById(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id);
    }

    //PUT UPDATE VENUE
    @Step("Put update venue")
    public void putUpdateVenue(String token, String id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //DELETE VENUE
    @Step("Delete Venue")
    public void deleteVenue(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id);
    }

    //POST ADD VENUE IMAGES
    @Step("Post add venue image")
    public void postAddVenueImage(String token, String id, File imageFile) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id)
                //.contentType(ContentType.MULTIPART_FORM_DATA)
                .multiPart("files", imageFile);
    }
    @Step("Post add venue image with blank body")
    public void postAddVenueImageWithBlankBody(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id);
    }

    //GET ALL IMAGE FOR A VENUE
    @Step("Get all image for a venue")
    public void getAllImageForAVenue(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id);
    }

    //GET ALL REVIEWS FOR A VENUE
    @Step("Get all reviews for a venue")
    public void getAllReviewsForAVenue(String token, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", id);
    }

    //DELETE VENUE IMAGE
    @Step("Delete Venue Image")
    public void deleteVenueImage(String token, String venue_id, String image_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("venue_id", venue_id)
                .pathParam("image_id", image_id);
    }








}
