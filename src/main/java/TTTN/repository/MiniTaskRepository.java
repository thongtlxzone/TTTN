package TTTN.repository;

import TTTN.entity.MiniTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiniTaskRepository extends JpaRepository<MiniTaskEntity,Integer> {
    @Query("select m from mini_task m where m.taskEntity.id = ?1")
    List<MiniTaskEntity> getAllMiniTaskByTaskId(int taskId);
}
