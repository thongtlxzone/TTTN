package TTTN.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    private int id;
    private String content;
    private LocalDateTime update;
    private String replyTo;
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

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
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
