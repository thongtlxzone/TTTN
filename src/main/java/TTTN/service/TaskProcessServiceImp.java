package TTTN.service;

import TTTN.entity.TaskEntity;
import TTTN.entity.TaskProcessEntity;
import TTTN.repository.TaskProcessRepository;
import TTTN.repository.TaskRepository;
import TTTN.service.imp.TaskProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class TaskProcessServiceImp implements TaskProcessService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    TaskProcessRepository taskProcessRepository;

    @Override
    public boolean createProcess(TaskProcessEntity taskProcess) {
        try{
            TaskEntity managedTaskEntity = entityManager.merge(taskProcess.getTaskEntity());
            taskProcess.setTaskEntity(managedTaskEntity);
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
