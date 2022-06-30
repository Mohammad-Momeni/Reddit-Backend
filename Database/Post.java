package Database;

import java.util.ArrayList;

public class Post {
    private String postText;
    private String postDate;
    private String postTime;
    private SubReddit subReddit;
    private int likes;
    private int dislikes;
    private ArrayList<Comment> comments;
    private int commentCount;
    private User poster;
    Post(String postText, String postDate, String postTime, SubReddit subReddit, int likes, int dislikes, User poster) {
        this.postText = postText;
        this.postDate = postDate;
        this.postTime = postTime;
        this.subReddit = subReddit;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = new ArrayList<Comment>();
        this.commentCount = 0;
        this.poster = poster;
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
    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public int getCommentCount() {
        return commentCount;
    }
    public User getPoster() {
        return poster;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
        commentCount++;
    }
    public String toString() {
        return postText + "," + postDate + "," + postTime + "," + subReddit + "," + likes + "," + dislikes + "," + comments + "," + commentCount + "," + poster + "\n";
    }
}