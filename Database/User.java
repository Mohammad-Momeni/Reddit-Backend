package Database;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<Post> posts;
    private ArrayList<Post> savedPosts;
    private int postCount;
    private int savedPostCount;
    private ArrayList<SubReddit> FavoriteSubReddits;
    private int favoriteSubRedditCount;
    User (String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.posts = new ArrayList<Post>();
        this.savedPosts = new ArrayList<Post>();
        this.postCount = 0;
        this.savedPostCount = 0;
        this.FavoriteSubReddits = new ArrayList<SubReddit>();
        this.favoriteSubRedditCount = 0;
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
    public int getSavedPostCount() {
        return savedPostCount;
    }
    public ArrayList<SubReddit> getFavoriteSubReddits() {
        return FavoriteSubReddits;
    }
    public int getFavoriteSubRedditCount() {
        return favoriteSubRedditCount;
    }
    public void addFavoriteSubReddit(SubReddit subReddit) {
        FavoriteSubReddits.add(subReddit);
        favoriteSubRedditCount++;
    }
    public void removeFavoriteSubReddit(SubReddit subReddit) {
        FavoriteSubReddits.remove(subReddit);
        favoriteSubRedditCount--;
    }
    public String toString() {
        return username + "," + password + "," + email + "," + posts + "," + postCount + "," + savedPosts + "," + savedPostCount + "," + FavoriteSubReddits + "," + favoriteSubRedditCount + "\n";
    }
}
