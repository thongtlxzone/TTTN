package TTTN.repository;

import TTTN.entity.TaskProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface TaskProcessRepository extends JpaRepository<TaskProcessEntity, Integer> {
    @Query("select p from task_process p where p.taskEntity.id = ?1")
    List<TaskProcessEntity> getAllProcessByTaskId(int taskId);
}
