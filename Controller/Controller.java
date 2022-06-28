package Controller;

public class Controller {
    private String login(String username, String password) {
        return "Login successful";
    }
    public String run(String request) {
        String[] requestParts = request.split("&&");
        if(requestParts[0].equals("login")) {
            return "login";
        }
        else if(requestParts[0].equals("signup")) {
            return "signup";
        }
        return "";
    }
}