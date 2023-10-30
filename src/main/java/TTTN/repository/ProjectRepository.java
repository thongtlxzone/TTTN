package TTTN.repository;

import TTTN.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
    List<ProjectEntity> findByProjectName(String projectName);
    ProjectEntity findById(int id);
    @Query("select p from project p where p.projectName like ?1")
    List<ProjectEntity> searchProject(String projectName);
}
