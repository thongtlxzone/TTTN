package TTTN.controller;

import TTTN.entity.UserInfoEntity;
import TTTN.service.imp.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personalinfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @GetMapping("")
    public ResponseEntity<?> showPersonalInfo(@PathVariable int userId){
        return new ResponseEntity<>(userInfoService.showPersonalInfo(userId), HttpStatus.OK);
    }
    @PostMapping("/newPersonalInfo")
    public ResponseEntity<?> newUserInfo(@RequestBody UserInfoEntity userInfo){
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
