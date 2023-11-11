package TTTN.service.imp;

import TTTN.dto.TaskDTO;
import TTTN.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasksOfProject(int projectId);
    boolean createTask(TaskEntity taskEntity);
    boolean deleteTask(int taskId, int userId);
    boolean changeTask(TaskEntity task, int userId);
    TaskDTO getTaskById(int taskId);
}
