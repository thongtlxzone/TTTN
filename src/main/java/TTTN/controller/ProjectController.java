package TTTN.controller;

import TTTN.entity.ProjectEntity;
import TTTN.service.imp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @PostMapping("/searchProjectByName")
    public ResponseEntity<?> getAllProjectsByName(@RequestParam String projectName){
        return new ResponseEntity<>(projectService.searchProjectByName(projectName),HttpStatus.OK);
    }
    @PostMapping("/showProject")
    public ResponseEntity<?> showProject(@RequestParam int projectId){
        return new ResponseEntity<>(projectService.showProject(projectId),HttpStatus.OK);
    }
    @PostMapping("/createProject")
    public ResponseEntity<?> created(@RequestBody ProjectEntity projectEntity, @RequestParam int userId){
        return new ResponseEntity<>(projectService.createProject(projectEntity, userId), HttpStatus.OK);
    }
    @PostMapping("/removeProject")
    public ResponseEntity<?> removeProject(@RequestParam int projectId, @RequestParam int userId){
        return new ResponseEntity<>(projectService.deletedProject(projectId,userId),HttpStatus.OK);
    }
    @PostMapping("/updateProject")
    public ResponseEntity<?> updateProject(@RequestBody ProjectEntity project, @RequestParam int userId){
        return new ResponseEntity<>(projectService.updateProject(project,userId),HttpStatus.OK);
    }
    @PostMapping("/showListTask")
    public ResponseEntity<?> showListTask(@RequestParam int projectId){
        return new ResponseEntity<>(projectService.showListTask(projectId),HttpStatus.OK);
    }
}
