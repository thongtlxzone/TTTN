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
    @OneToMany(mappedBy = "taskEntity")
    private Set<TaskProcessEntity> taskProcessEntities;
    @OneToMany(mappedBy = "taskEntity")
    private Set<MiniTaskEntity> miniTaskEntities;
    @OneToMany(mappedBy = "taskEntity")
    private Set<CommentEntity> commentEntities;
}
