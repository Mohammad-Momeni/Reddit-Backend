package Database;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<Post> posts;
    private ArrayList<Post> savedPosts;
    private int postCount;
    User (String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.posts = new ArrayList<Post>();
        this.savedPosts = new ArrayList<Post>();
        this.postCount = 0;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }
    public int getPostCount() {
        return postCount;
    }
    public ArrayList<Post> getSavedPosts() {
        return savedPosts;
    }
    public void addPost(Post post) {
        posts.add(post);
        postCount++;
    }
    public void removePost(Post post) {
        posts.remove(post);
        postCount--;
    }
    public void addSavedPost(Post post) {
        savedPosts.add(post);
    }
    public void removeSavedPost(Post post) {
        savedPosts.remove(post);
    }
}
