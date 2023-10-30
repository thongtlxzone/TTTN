package TTTN.repository;

import TTTN.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
    @Query("select c from comment c where c.taskEntity.id = ?1")
    List<CommentEntity> getAllCommentsByTaskId(int taskId);
}
