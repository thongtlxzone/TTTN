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
    private Date startTime;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
