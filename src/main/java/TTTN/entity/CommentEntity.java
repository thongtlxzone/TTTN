package TTTN.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdate;
    @OneToOne
    @JoinColumn(name = "reply_cmt_id")
    private CommentEntity replyComment;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;

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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public CommentEntity getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(CommentEntity replyComment) {
        this.replyComment = replyComment;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
