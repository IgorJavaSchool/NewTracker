package yanevskyy;

/**
 * Комментарий для заявки
 */
public class Comment {

    public String commentMessage;

    public Comment(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }
}
