package Database;

import java.util.ArrayList;

public class SubReddit {
    private String subRedditName;
    private ArrayList<Post> posts;
    private int postCount;
    SubReddit(String subRedditName) {
        this.subRedditName = subRedditName;
        this.posts = new ArrayList<Post>();
        this.postCount = 0;
    }
    public String getSubRedditName() {
        return subRedditName;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }
    public int getPostCount() {
        return postCount;
    }
}
