package TTTN.entity;

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
    private RoleEntity roleEntity;
    @OneToMany(mappedBy = "usersEntity")
    private Set<UserInfoEntity> userInfoEntities;
    @OneToMany(mappedBy = "usersEntity")
    private Set<HistoryActionEntity> historyActionEntities;
    @OneToMany(mappedBy = "usersEntity")
    private Set<CommentEntity> commentEntities;
    @OneToMany(mappedBy = "usersEntity")
    private Set<ProjectNUserEntity> projectNUserEntities;

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
