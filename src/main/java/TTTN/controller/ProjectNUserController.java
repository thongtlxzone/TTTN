package TTTN.controller;

import TTTN.service.imp.ProjectNUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/projectNuser")
public class ProjectNUserController {
    @Autowired
    ProjectNUserService projectNUserService;

    @PostMapping("/getAllProjectsByUser")
    public ResponseEntity<?> getAllProjectsByUser(@RequestParam int userId){
        return new ResponseEntity<>(projectNUserService.getAllProjectByUser(userId), HttpStatus.OK);
    }
    @PostMapping("/getAllUsersByProject")
    public ResponseEntity<?> getAllUsersByProject(@RequestParam int projectId){
        return new ResponseEntity<>(projectNUserService.getAllUserByProject(projectId), HttpStatus.OK);
    }
    @PostMapping("/newPNU")//tao lien ket giua user va project moi hoac them nguoi dung vao 1 project nao do
    public ResponseEntity<?> creatNewProjectNUser(@RequestParam int userId, @RequestParam int projectId){
        return new ResponseEntity<>(projectNUserService.createNewProjectNUser(userId,projectId), HttpStatus.OK);
    }
}
