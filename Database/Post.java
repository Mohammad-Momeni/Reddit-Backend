package Database;

public class Post {
    private String postText;
    private String postDate;
    private String postTime;
    private SubReddit subReddit;
    Post(String postText, String postDate, String postTime, SubReddit subReddit) {
        this.postText = postText;
        this.postDate = postDate;
        this.postTime = postTime;
        this.subReddit = subReddit;
    }
    public String getPostText() {
        return postText;
    }
    public String getPostDate() {
        return postDate;
    }
    public String getPostTime() {
        return postTime;
    }
    public SubReddit getSubReddit() {
        return subReddit;
    }
}