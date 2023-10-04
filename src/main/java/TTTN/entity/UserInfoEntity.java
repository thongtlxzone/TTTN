package TTTN.entity;

import javax.persistence.*;

@Entity(name = "userinfo")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
