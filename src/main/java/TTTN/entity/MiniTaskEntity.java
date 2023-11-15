package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity(name = "mini_task")
public class MiniTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "mini_task_name")
    private String miniTaskName;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private TaskEntity taskEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMiniTaskName() {
        return miniTaskName;
    }

    public void setMiniTaskName(String miniTaskName) {
        this.miniTaskName = miniTaskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
