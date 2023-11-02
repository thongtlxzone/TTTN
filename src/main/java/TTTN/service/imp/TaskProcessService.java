package TTTN.service.imp;

import TTTN.entity.TaskProcessEntity;

import java.util.List;

public interface TaskProcessService {
    boolean createProcess(TaskProcessEntity taskProcess);
    List<TaskProcessEntity> getAllProcessByTaskId(int taskId);
}
