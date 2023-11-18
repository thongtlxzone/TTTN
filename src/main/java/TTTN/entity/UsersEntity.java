package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }

    public Set<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(Set<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }

    @Column(name = "fullname")
    private String fullname;
    @Column(name = "avartar")
    private String avatar;
    @Column(name = "email")
    private String email;
    @Column(name = "account_status")
    private String status;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference(value = "user-role")
    private RoleEntity roleEntity;
    @OneToMany(mappedBy = "projectManager",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-project")
    private Set<ProjectEntity> projectEntities;
    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-task")
    private Set<TaskEntity> taskEntities;
    @OneToMany(mappedBy = "usersEntity",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-uinfo")
    private Set<UserInfoEntity> userInfoEntities;
    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-history")
    private Set<HistoryActionEntity> historyActionEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-comment")
    private Set<CommentEntity> commentEntities;
    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-projectNuser")
    private Set<ProjectNUserEntity> projectNUserEntities;
    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-taskprocess")
    private Set<TaskProcessEntity> taskProcessOfUser;
    public UsersEntity(){}
    public UsersEntity(int id) {
        this.id = id;
    }

    public Set<UserInfoEntity> getUserInfoEntities() {
        return userInfoEntities;
    }

    public void setUserInfoEntities(Set<UserInfoEntity> userInfoEntities) {
        this.userInfoEntities = userInfoEntities;
    }

    public Set<HistoryActionEntity> getHistoryActionEntities() {
        return historyActionEntities;
    }

    public void setHistoryActionEntities(Set<HistoryActionEntity> historyActionEntities) {
        this.historyActionEntities = historyActionEntities;
    }

    public Set<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public Set<ProjectNUserEntity> getProjectNUserEntities() {
        return projectNUserEntities;
    }

    public void setProjectNUserEntities(Set<ProjectNUserEntity> projectNUserEntities) {
        this.projectNUserEntities = projectNUserEntities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
