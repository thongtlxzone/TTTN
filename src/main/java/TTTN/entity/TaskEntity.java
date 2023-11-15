package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "taskname")
    private String taskName;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;
    @Column(name = "task_status")
    private boolean taskStatus;
    @Column(name = "deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonManagedReference
    private UsersEntity manager;
    @OneToOne
    @JoinColumn(name = "reporter_id")
    @JsonManagedReference
    private UsersEntity reporter;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonManagedReference
    private ProjectEntity projectEntity;
    @ManyToOne
    @JoinColumn(name = "task_type_id")
    @JsonManagedReference
    private TaskTypeEntity taskTypeEntity;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<TaskProcessEntity> taskProcessEntities;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<MiniTaskEntity> miniTaskEntities;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<CommentEntity> commentEntities;

    public TaskEntity(){}
    public TaskEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isTaskDone() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public UsersEntity getManager() {
        return manager;
    }

    public void setManager(UsersEntity manager) {
        this.manager = manager;
    }

    public UsersEntity getReporter() {
        return reporter;
    }

    public void setReporter(UsersEntity reporter) {
        this.reporter = reporter;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public TaskTypeEntity getTaskTypeEntity() {
        return taskTypeEntity;
    }

    public void setTaskTypeEntity(TaskTypeEntity taskTypeEntity) {
        this.taskTypeEntity = taskTypeEntity;
    }

    public Set<TaskProcessEntity> getTaskProcessEntities() {
        return taskProcessEntities;
    }

    public void setTaskProcessEntities(Set<TaskProcessEntity> taskProcessEntities) {
        this.taskProcessEntities = taskProcessEntities;
    }

    public Set<MiniTaskEntity> getMiniTaskEntities() {
        return miniTaskEntities;
    }

    public void setMiniTaskEntities(Set<MiniTaskEntity> miniTaskEntities) {
        this.miniTaskEntities = miniTaskEntities;
    }

    public Set<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
}
