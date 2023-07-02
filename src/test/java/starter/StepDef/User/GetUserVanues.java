package starter.StepDef.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.PlaygroundPro.User;

public class GetUserVanues {
    @Steps
    User user;

    @Given("Get users venues with valid token")
    public void getUserVenues() throws Exception {
        User.getUserVenuesValidToken();
    }

    @Given("Get users venues with invalid token")
    public void getUsersVenuesWithInvalidToken() throws Exception {
        User.getUserVenuesInvalidToken();
    }

    @When("Send get users venues")
    public void sendGetUserVenues() {

        Response response = SerenityRest.when().get(User.USER_VENUES);
        System.out.println(response.jsonPath().getString("message"));    }


}
