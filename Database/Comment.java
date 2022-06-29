package Database;

public class Comment {
    private String text;
    private User author;
    private int likes;
    private int dislikes;
    private Comment[] replies;
    private int repliesCount;
    Comment(String text, User author) {
        this.text = text;
        this.author = author;
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
}
