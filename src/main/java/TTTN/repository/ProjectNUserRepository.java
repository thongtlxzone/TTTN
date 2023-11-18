package TTTN.repository;

import TTTN.entity.ProjectNUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectNUserRepository extends JpaRepository<ProjectNUserEntity, Integer> {
    @Query("select p from project_n_user as p where p.usersEntity.id = ?1")
    List<ProjectNUserEntity> getAllProjectByUserId(int userId);
    @Query("select p from project_n_user as p where p.projectEntity.id = ?1")
    List<ProjectNUserEntity> getAllUserByProjectId(int projectId);
    @Query("SELECT p FROM project_n_user p WHERE p.usersEntity.id = ?1 AND p.projectEntity.id = ?2")
    List<ProjectNUserEntity> getAllByUserIdAndProjectId(int userId, int projectId);
}
