package TTTN.service;

import TTTN.dto.TaskDTO;
import TTTN.entity.TaskEntity;
import TTTN.repository.TaskRepository;
import TTTN.service.imp.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public List<TaskDTO> getAllTasksOfProject(int projectId) {
        List<TaskEntity> listTasks = taskRepository.getAllTaskByProjectId(projectId);
        List<TaskDTO> listTasksDTO = new ArrayList<>();
        for (TaskEntity task : listTasks) {
            TaskDTO temp = new TaskDTO();
            temp.setId(task.getId());
            temp.setTaskName(task.getTaskName());
            temp.setTaskStatus(task.isTaskDone());
            temp.setCategory(task.getCategory());
            temp.setDescription(task.getDescription());
            temp.setDateCreated(task.getDateCreated());
            temp.setDeadline(task.getDeadline());
            temp.setManagerName(task.getManager().getFullname());
            temp.setReporter(task.getReporter().getFullname());
            temp.setTasktype(task.getTaskTypeEntity().getTaskTypeName());
            listTasksDTO.add(temp);
        }
        return listTasksDTO;
    }

    @Override
    public boolean createTask(TaskEntity taskEntity, int userId) {
        if(taskEntity.getManager().getId()!=userId){
            System.out.println("Loi tao task");
            return false;
        }else {
            taskRepository.save(taskEntity);
            return true;
        }
    }

    @Override
    public boolean deleteTask(int taskId, int userId) {
        try {
            TaskEntity task = taskRepository.findById(userId).get();
            if(task.getManager().getId() == userId){
                taskRepository.delete(task);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Loi xoa task " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean changeTask(TaskEntity task, int userId) {
        if(task.getManager().getId()==userId && taskRepository.existsById(task.getId())){
            taskRepository.save(task);
            return true;
        }else {
            System.out.println("Loi thay doi task");
            return false;
        }
    }
}
