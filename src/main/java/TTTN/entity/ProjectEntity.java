package TTTN.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
