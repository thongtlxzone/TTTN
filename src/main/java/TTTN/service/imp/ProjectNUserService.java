package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.dto.UsersDTO;

import java.util.List;

public interface ProjectNUserService {
    List<ProjectDTO> getALlProjectByUser(int userId);
    List<UsersDTO> getALlUserByProject(int projectId);
    boolean createNewProjectNUser(int userId, int projectId);
}
