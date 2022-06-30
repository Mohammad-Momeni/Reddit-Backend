package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Database.Database;

public class Controller {
    private String login(String username, String password) {
        try {
            ArrayList<String> data = Database.getInstance().getTable("&&User").get();
            for (String line : data) {
                if(line.equals(username)) {
                    ArrayList<String> userData = Database.getInstance().getTable(username).get();
                    String[] userDataArray = userData.get(0).split(",");
                    if(userDataArray[1].equals(password)) {
                        return "success";
                    }
                }
            }
            return "wrong username or password";
        } catch (IOException e) {
            return "error";
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
                if(isDuplicate(username, email)) {
                    return "duplicate";
                }
                Database.getInstance().getTable("&&User").insert(username);
                Database.getInstance().addTable(username, "./Data/" + username + ".txt");
                Database.getInstance().getTable(username).insert(username + "," + password + "," + email);
                return "success";
            } catch(Exception e) {
                return "error";
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
    public boolean isDuplicate(String username,String email) {
        try {
            ArrayList<String> data = Database.getInstance().getTable("&&User").get();
            for (String line : data) {
                if(line.equals(username)) {
                    return true;
                }
                ArrayList<String> userData = Database.getInstance().getTable(line).get();
                String[] userDataArray = userData.get(0).split(",");
                if(userDataArray[2].equals(email)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}