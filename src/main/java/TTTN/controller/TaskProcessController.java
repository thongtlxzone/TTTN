package TTTN.controller;

import TTTN.entity.TaskProcessEntity;
import TTTN.service.imp.TaskProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/taskProcess")
public class TaskProcessController {
    @Autowired
    TaskProcessService taskProcessService;
    @PostMapping("/createProcess")
    public ResponseEntity<?> createProcess(@RequestBody TaskProcessEntity taskProcess){
        return new ResponseEntity<>(taskProcessService.createProcess(taskProcess), HttpStatus.OK);
    }
    @PostMapping("/viewProcess")
    public ResponseEntity<?> getProcess(@RequestParam int taskId){
        return new ResponseEntity<>(taskProcessService.getAllProcessByTaskId(taskId),HttpStatus.OK);
    }

}
