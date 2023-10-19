package TTTN.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_avatar")
    private String projectAvatar;
    @OneToOne
    @JoinColumn(name = "user_created_id")
    private UsersEntity userCreatedId;
    @OneToOne
    @JoinColumn(name = "project_manager_id")
    private UsersEntity projectManagerId;
    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectTypeEntity projectTypeEntity;
    @OneToMany(mappedBy = "projectEntity")
    private Set<ProjectNUserEntity> projectNUserEntities;
    @OneToMany(mappedBy = "projectEntity")
    private Set<TaskEntity> taskEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAvatar() {
        return projectAvatar;
    }

    public void setProjectAvatar(String projectAvatar) {
        this.projectAvatar = projectAvatar;
    }

    public UsersEntity getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(UsersEntity userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public UsersEntity getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(UsersEntity projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public ProjectTypeEntity getProjectTypeEntity() {
        return projectTypeEntity;
    }

    public void setProjectTypeEntity(ProjectTypeEntity projectTypeEntity) {
        this.projectTypeEntity = projectTypeEntity;
    }

    public Set<ProjectNUserEntity> getProjectNUserEntities() {
        return projectNUserEntities;
    }

    public void setProjectNUserEntities(Set<ProjectNUserEntity> projectNUserEntities) {
        this.projectNUserEntities = projectNUserEntities;
    }

    public Set<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(Set<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
