package TTTN.dto;

public class ProjectDTO {
    private int id;
    private String projectName;
    private int userCreatedId;
    private int projectManagerId;
    private String projectAvatar;
    private int projectTypeId;

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

    public int getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(int userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public int getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(int projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public int getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(int projectTypeId) {
        this.projectTypeId = projectTypeId;
    }
}
