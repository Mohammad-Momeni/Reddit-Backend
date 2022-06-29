package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Database.Database;

public class Controller {
    private String login(String username, String password) {
        if(username.equals("MohammadM404") && password.equals("matin@123")) {
            return "success";
        } else {
            return "failed";
        }
    }
    private String signUp(String username, String password, String email) {
        Pattern pattern1 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(email);
        Pattern pattern2 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher2 = pattern2.matcher(password);
        if(!matcher1.find()) {
            return "email invalid";
        } else if(!matcher2.find()) {
            return "password invalid";
        } else {
            try {
                Database.getInstance().getTable("&&User").insert(username);
                Database.getInstance().addTable(username, "src/Data/" + username + ".txt");
                Database.getInstance().getTable(username).insert(password + "," + email);
            return "success";
            } catch(Exception e) {
                return "failed";
            }
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