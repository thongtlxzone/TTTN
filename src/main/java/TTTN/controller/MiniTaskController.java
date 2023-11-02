package TTTN.controller;

import TTTN.entity.MiniTaskEntity;
import TTTN.service.imp.MiniTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/minitask")
public class MiniTaskController {
    @Autowired
    MiniTaskService miniTaskService;
    @PostMapping("/getMinitask")
    public ResponseEntity<?> getAllMiniTaskByTaskId(@RequestParam int taskId){
        return new ResponseEntity<>(miniTaskService.getAllMiniTaskByTaskId(taskId), HttpStatus.OK);
    }
    @PostMapping("/createMinitask")
    public ResponseEntity<?> createMiniTask(@RequestBody MiniTaskEntity miniTask, @RequestParam int userId){
        return new ResponseEntity<>(miniTaskService.createMiniTask(miniTask,userId), HttpStatus.OK);
    }
    @PostMapping("/deleteMinitask")
    public ResponseEntity<?> deleteMiniTask(@RequestParam int miniTaskId, @RequestParam int userId){
        return new ResponseEntity<>(miniTaskService.deleteMiniTask(miniTaskId,userId), HttpStatus.OK);
    }
}
