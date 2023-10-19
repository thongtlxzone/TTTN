package TTTN.controller;

import TTTN.entity.ProjectEntity;
import TTTN.service.imp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(name = "/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @PostMapping(name = "/createProject")
    public ResponseEntity<?> created(@RequestBody ProjectEntity projectEntity){
        return new ResponseEntity<>(projectService.createProject(projectEntity), HttpStatus.OK);
    }
    @PostMapping(path = "/removeProject")
    public ResponseEntity<?> removeProject(@RequestParam int projectId, @RequestParam int userId){
        return new ResponseEntity<>(projectService.deletedProject(projectId,userId),HttpStatus.OK);
    }
}
