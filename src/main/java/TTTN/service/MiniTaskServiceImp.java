package TTTN.service;

import TTTN.dto.MiniTaskDTO;
import TTTN.entity.MiniTaskEntity;
import TTTN.repository.MiniTaskRepository;
import TTTN.service.imp.MiniTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiniTaskServiceImp implements MiniTaskService {
    @Autowired
    MiniTaskRepository miniTaskRepository;
    @Override
    public List<MiniTaskDTO> getAllMiniTaskByTaskId(int taskId) {
        List<MiniTaskEntity> list = miniTaskRepository.getAllMiniTaskByTaskId(taskId);
        List<MiniTaskDTO> miniTaskDTOs = new ArrayList<>();
        for (MiniTaskEntity miniTask : list) {
            MiniTaskDTO miniTaskDTO = new MiniTaskDTO();
            miniTaskDTO.setId(miniTask.getId());
            miniTaskDTO.setMiniTaskName(miniTaskDTO.getMiniTaskName());
            miniTaskDTO.setDescription(miniTaskDTO.getDescription());
            miniTaskDTOs.add(miniTaskDTO);
        }
        return miniTaskDTOs;
    }

    @Override
    public boolean createMiniTask(MiniTaskEntity miniTask, int userId) {
        if(userId == miniTask.getTaskEntity().getManager().getId()){
            miniTaskRepository.save(miniTask);
            return true;
        }else {
            System.out.println("Loi tao minitask");
            return false;
        }
    }

    @Override
    public boolean deleteMiniTask(int miniTaskId, int userId) {
        if(userId == miniTaskRepository.findById(miniTaskId).get().getTaskEntity().getManager().getId()){
            miniTaskRepository.deleteById(miniTaskId);
            return true;
        }else {
            System.out.println("Loi xoa minitask");
            return false;
        }
    }
}
