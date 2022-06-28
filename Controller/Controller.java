package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private String login(String username, String password) {
        if(username.equals("MohammadM404") && password.equals("matin@123")) {
            return "success";
        } else {
            return "failed";
        }
    }
    private String signUp(String username, String password, String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            return "created";
        } else {
            return "invalid email";
        }
    }
    public String run(String request) {
        String[] requestParts = request.split("&&");
        switch (requestParts[0]) {
            case "login":
                return login(requestParts[1], requestParts[2]);
            case "signUp":
                return signUp(requestParts[1], requestParts[2], requestParts[3]);
            default:
                return "invalid request";
        }
    }
}