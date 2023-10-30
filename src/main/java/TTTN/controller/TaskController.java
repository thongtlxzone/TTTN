package TTTN.controller;

import TTTN.entity.TaskEntity;
import TTTN.service.imp.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping("/getAllTasksOfProject")
    public ResponseEntity<?> getAllTasksOfProject(@RequestParam int projectId){
        return new ResponseEntity<>(taskService.getAllTasksOfProject(projectId), HttpStatus.OK);
    }
    @PostMapping("/createTask")
    public ResponseEntity<?> createTask(@RequestBody TaskEntity task, @RequestParam int userId){
        return new ResponseEntity<>(taskService.createTask(task,userId),HttpStatus.OK);
    }
    @PostMapping("/deleteTask")
    public ResponseEntity<?> deleteTask(@RequestParam int taskId, @RequestParam int userId){
        return new ResponseEntity<>(taskService.deleteTask(taskId,userId),HttpStatus.OK);
    }
    @PostMapping("/changeTask")
    public ResponseEntity<?> changeTask(@RequestBody TaskEntity task, @RequestParam int userId){
        return new ResponseEntity<>(taskService.changeTask(task,userId),HttpStatus.OK);
    }
}
