package TTTN.entity;

import javax.persistence.*;
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
    @OneToOne
    @JoinColumn(name = "manager_id")
    private UsersEntity manager;
    @OneToOne
    @JoinColumn(name = "reporter_id")
    private UsersEntity reporter;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;
    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskTypeEntity taskTypeEntity;
    @ManyToOne
    @JoinColumn(name = "task_plan_id")
    private TaskPlanEntity taskPlanEntity;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TaskProcessEntity> taskProcessEntities;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MiniTaskEntity> miniTaskEntities;
    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentEntity> commentEntities;

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

    public boolean isTaskStatus() {
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

    public TaskPlanEntity getTaskPlanEntity() {
        return taskPlanEntity;
    }

    public void setTaskPlanEntity(TaskPlanEntity taskPlanEntity) {
        this.taskPlanEntity = taskPlanEntity;
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
