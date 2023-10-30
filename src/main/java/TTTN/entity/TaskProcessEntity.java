package TTTN.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "task_process")
public class TaskProcessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

}
