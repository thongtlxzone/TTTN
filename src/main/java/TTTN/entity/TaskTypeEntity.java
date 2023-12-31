package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "task_type")
public class TaskTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "task_type_name")
    private String taskTypeName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "taskTypeEntity", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "task-taskType")
    private Set<TaskEntity> taskEntities;
    public TaskTypeEntity(){}

    public TaskTypeEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(Set<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
