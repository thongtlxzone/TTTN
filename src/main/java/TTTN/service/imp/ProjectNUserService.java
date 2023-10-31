package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.dto.UsersDTO;

import java.util.List;

public interface ProjectNUserService {
    List<ProjectDTO> getAllProjectByUser(int userId);
    List<UsersDTO> getAllUserByProject(int projectId);
    boolean createNewProjectNUser(int userId, int projectId);

}
