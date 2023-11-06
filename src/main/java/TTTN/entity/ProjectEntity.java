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
    @Column(name = "user_created")
    private String userCreated;
    @ManyToOne
    @JoinColumn(name = "project_manager_id")
    private UsersEntity projectManager;
    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectTypeEntity projectTypeEntity;
    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProjectNUserEntity> projectNUserEntities;
    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public UsersEntity getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(UsersEntity projectManager) {
        this.projectManager = projectManager;
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
