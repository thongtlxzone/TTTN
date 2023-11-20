package TTTN.service;

import TTTN.dto.TaskDTO;
import TTTN.entity.TaskEntity;
import TTTN.repository.TaskRepository;
import TTTN.service.imp.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public boolean createTask(TaskEntity taskEntity) {
        try{
            taskRepository.save(taskEntity);
            return true;
        }catch (Exception e){
            System.out.println("Loi tao task " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTask(int taskId, int userId) {
        try {
            TaskEntity task = taskRepository.findById(taskId).get();
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
        Optional<TaskEntity> optionalTask = taskRepository.findById(task.getId());

        if (optionalTask.isPresent()) {
            TaskEntity changedTask = optionalTask.get();

            if (changedTask.getManager() != null && changedTask.getManager().getId() == userId) {
                changedTask.setId(task.getId());
                changedTask.setCategory(task.getCategory());
                changedTask.setTaskName(task.getTaskName());
                changedTask.setTaskStatus(task.isTaskDone());
                changedTask.setDeadline(task.getDeadline());
                changedTask.setDescription(task.getDescription());
                changedTask.setReporter(task.getReporter());
                changedTask.setManager(task.getManager());
                changedTask.setTaskTypeEntity(task.getTaskTypeEntity());
                taskRepository.save(changedTask);
                return true;
            } else {
                System.out.println("Loi thay doi task");
                return false;
            }
        } else {
            System.out.println("Task khong ton tai");
            return false;
        }
    }

    @Override
    public TaskDTO getTaskById(int taskId) {
        if(taskRepository.existsById(taskId)){
            TaskEntity task = taskRepository.findById(taskId).get();
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
            return temp;
        }else {
            System.out.println("Loi lay thong tin task");
            return null;
        }
    }
}
