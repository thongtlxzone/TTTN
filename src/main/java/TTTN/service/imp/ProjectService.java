package TTTN.service.imp;

import TTTN.entity.ProjectEntity;

public interface ProjectService {
    boolean createProject(ProjectEntity projectEntity);
    boolean deletedProject(int projectId, int userId);
}
