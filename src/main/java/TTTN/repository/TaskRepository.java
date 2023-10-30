package TTTN.repository;

import TTTN.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    @Query("select t from task as t where t.projectEntity.id = ?1")
    List<TaskEntity> getAllTaskByProjectId(int projectId);
}
