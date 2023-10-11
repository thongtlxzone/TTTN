package TTTN.entity;

import javax.persistence.*;

@Entity(name = "mini_task")
public class MiniTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "mini_task_name")
    private String miniTaskName;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
}
