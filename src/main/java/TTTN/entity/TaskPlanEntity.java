package TTTN.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "task_plan")
public class TaskPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "day_of_create")
    @Temporal(TemporalType.DATE)
    private Date dayOfCreate;
    @Column(name = "start_day_expect")
    @Temporal(TemporalType.DATE)
    private Date startDayExpect;
    @Column(name = "end_day_expect")
    @Temporal(TemporalType.DATE)
    private Date endDayExpect;
    @Column(name = "start_day_actual")
    @Temporal(TemporalType.DATE)
    private Date startDayActual;
    @Column(name = "end_day_actual")
    @Temporal(TemporalType.DATE)
    private Date endDayActual;
    @OneToMany(mappedBy = "taskPlanEntity")
    private Set<TaskEntity> taskEntities;
}
