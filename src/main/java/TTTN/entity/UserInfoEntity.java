package TTTN.entity;

import javax.persistence.*;

@Entity(name = "userinfo")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "job")
    private String job;
    @Column(name = "major")
    private String major;
    @Column(name = "hobby")
    private String hobby;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
    public UserInfoEntity(){}
    public UserInfoEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
