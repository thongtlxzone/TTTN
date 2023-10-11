package TTTN.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "task_type")
public class TaskTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "task_type_name")
    private String taskTypeName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "taskTypeEntity")
    private Set<TaskEntity> taskEntities;
}
