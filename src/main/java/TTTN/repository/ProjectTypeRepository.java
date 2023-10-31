package TTTN.repository;

import TTTN.entity.ProjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectTypeEntity, Integer> {
    ProjectTypeEntity getById(int id);
}
