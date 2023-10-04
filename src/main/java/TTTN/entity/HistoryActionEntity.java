package TTTN.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "history_action")
public class HistoryActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(name = "content")
    private String content;
    @Column(name = "updated_content")
    private String updatedContent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
}
