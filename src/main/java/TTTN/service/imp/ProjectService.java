package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    ProjectDTO showProject(int projectId);
    boolean createProject(ProjectEntity projectEntity);
    boolean deletedProject(int projectId, int userId);
    boolean updateProject(ProjectEntity project, int userId);
    List<ProjectDTO> searchProjectByName(String projectName);
}
