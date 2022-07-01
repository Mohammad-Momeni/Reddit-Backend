package Database;

public class Comment {
    private String text;
    private User author;
    private int likes;
    private int dislikes;
    private Comment[] replies;
    private int repliesCount;
    private String date;
    private Post post;
    Comment(String text, User author, String date, Post post) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.post = post;
        this.likes = 0;
        this.dislikes = 0;
        this.replies = new Comment[10];
        this.repliesCount = 0;
    }
    public void like() {
        this.likes++;
    }
    public void dislike() {
        this.dislikes++;
    }
    public void reply(Comment comment) {
        this.replies[this.repliesCount] = comment;
        this.repliesCount++;
    }
    public String getText() {
        return text;
    }
    public User getAuthor() {
        return author;
    }
    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }
    public Comment[] getReplies() {
        return replies;
    }
    public int getRepliesCount() {
        return repliesCount;
    }
    public String getDate() {
        return date;
    }
    public Post getPost() {
        return post;
    }
    public String toString() {
        return text + "," + author + "," + date + "," + likes + "," + dislikes + "," + post + "\n";
    }
}
