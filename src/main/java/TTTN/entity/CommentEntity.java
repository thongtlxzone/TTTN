package TTTN.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;
    @Column(name = "reply_cmt_id")
    private int replyComment;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
}
