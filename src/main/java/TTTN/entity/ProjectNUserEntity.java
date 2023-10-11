package TTTN.entity;

import javax.persistence.*;

@Entity(name = "project_n_user")
public class ProjectNUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;
}
