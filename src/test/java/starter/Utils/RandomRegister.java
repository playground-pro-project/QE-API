package starter.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.PlaygroundPro.Authentication;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class RandomRegister {
    public static String[] RandomRegister() throws Exception {

        String randomEmail = UUID.randomUUID().toString();
        String randomPhone = generateRandomString();

        Map<String, String> body = new HashMap<String, String>();
        body.put("fullname", "randomRegistUser");
        body.put("email", randomEmail+"@gmail.com");
        body.put("phone", "081"+randomPhone);
        body.put( "password", "@Derinm01#");

        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON).body(body).post(Authentication.REGISTER);

        String userId = response.jsonPath().getString("data.user_id");
        String otp = response.jsonPath().getString("data.otp");
        String email = response.jsonPath().getString("data.email");

        return new String[]{ otp, userId, email };
    }

    public static String generateRandomString() {
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
