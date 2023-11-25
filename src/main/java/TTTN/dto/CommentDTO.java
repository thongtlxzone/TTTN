package TTTN.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class CommentDTO {
    private int id;
    private String content;
    private Date update;
    private int replyTo;
    private String userCommentName;
    private int taskId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(int replyTo) {
        this.replyTo = replyTo;
    }

    public String getUserCommentName() {
        return userCommentName;
    }

    public void setUserCommentName(String userCommentName) {
        this.userCommentName = userCommentName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
