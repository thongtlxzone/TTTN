package TTTN.repository;

import TTTN.entity.HistoryActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface HistoryActionRepository extends JpaRepository<HistoryActionEntity, Integer> {
    @Query("select h from history_action h where h.usersEntity.id = ?1")
    List<HistoryActionEntity> getAllHistoryActionByUserId(int userId);
}
