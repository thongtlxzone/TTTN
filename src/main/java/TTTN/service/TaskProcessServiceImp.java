package TTTN.service;

import TTTN.entity.TaskProcessEntity;
import TTTN.repository.TaskProcessRepository;
import TTTN.repository.TaskRepository;
import TTTN.service.imp.TaskProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskProcessServiceImp implements TaskProcessService {
    @Autowired
    TaskProcessRepository taskProcessRepository;

    @Override
    public boolean createProcess(TaskProcessEntity taskProcess) {
        try{
            taskProcessRepository.save(taskProcess);
            return true;
        }catch (Exception ex){
            System.out.println("Loi tao process "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<TaskProcessEntity> getAllProcessByTaskId(int taskId) {
        List<TaskProcessEntity> listTaskProcess = new ArrayList<>();
        try{
            listTaskProcess.addAll(taskProcessRepository.getAllProcessByTaskId(taskId));
        }catch (Exception ex){
            System.out.println("loi xem task process "+ex.getMessage());
        }
        return listTaskProcess;
    }
}
