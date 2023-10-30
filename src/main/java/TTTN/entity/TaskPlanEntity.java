package TTTN.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "task_plan")
public class TaskPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayOfCreate() {
        return dayOfCreate;
    }

    public void setDayOfCreate(Date dayOfCreate) {
        this.dayOfCreate = dayOfCreate;
    }

    public Date getStartDayExpect() {
        return startDayExpect;
    }

    public void setStartDayExpect(Date startDayExpect) {
        this.startDayExpect = startDayExpect;
    }

    public Date getEndDayExpect() {
        return endDayExpect;
    }

    public void setEndDayExpect(Date endDayExpect) {
        this.endDayExpect = endDayExpect;
    }

    public Date getStartDayActual() {
        return startDayActual;
    }

    public void setStartDayActual(Date startDayActual) {
        this.startDayActual = startDayActual;
    }

    public Date getEndDayActual() {
        return endDayActual;
    }

    public void setEndDayActual(Date endDayActual) {
        this.endDayActual = endDayActual;
    }

    public Set<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(Set<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
