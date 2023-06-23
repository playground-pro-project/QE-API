package starter.Utils;

public class PayloadUsers {
    public String bodyRequestRegisterUsers(String fullname, String email, String phone, String password) {
        String jsonString;
        jsonString = "{";
        jsonString += "\"nama\": \"" + fullname + "\",";
        jsonString += "\"email\": \"" + email + "\",";
        jsonString += "\"email\": \"" + phone + "\",";
        jsonString += "\"password\": \"" + password + "\"";
        jsonString += "}";

        return jsonString;
    }

    public String bodyRequestLoginUsers(String email, String password) {
        String jsonString;
        jsonString = "{";
        jsonString += "\"email\": \"" + email + "\",";
        jsonString += "\"password\": \"" + password + "\"";
        jsonString += "}";

        return jsonString;
    }

}
