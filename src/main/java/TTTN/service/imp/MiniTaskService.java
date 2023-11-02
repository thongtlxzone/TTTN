package TTTN.service.imp;

import TTTN.dto.MiniTaskDTO;
import TTTN.entity.MiniTaskEntity;

import java.util.List;

public interface MiniTaskService {
    List<MiniTaskDTO> getAllMiniTaskByTaskId(int taskId);
    boolean createMiniTask(MiniTaskEntity miniTask, int userId);
    boolean deleteMiniTask(int miniTaskId, int userId);
}
