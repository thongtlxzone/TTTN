package TTTN.controller;

import TTTN.service.imp.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/projectType")
public class ProjectTypeController {
    @Autowired
    ProjectTypeService projectTypeService;
    @PostMapping("/projectTypeData")
    public ResponseEntity<?> projectTypeData(@RequestParam int prjTypeId){
        return new ResponseEntity<>(projectTypeService.projectTypeData(prjTypeId),HttpStatus.OK);
    }
    @PostMapping("/getAllProjectType")
    public ResponseEntity<?> getALlPrjType(){
        return new ResponseEntity<>(projectTypeService.getAllProjectType(), HttpStatus.OK);
    }
}
