package TTTN.controller;

import TTTN.entity.UserInfoEntity;
import TTTN.service.imp.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/personalinfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/showPersonalInfo")
    public ResponseEntity<?> showPersonalInfo(@PathVariable int userId){
        return new ResponseEntity<>(userInfoService.showPersonalInfo(userId), HttpStatus.OK);
    }
    @PostMapping("/newPersonalInfo")
    public ResponseEntity<?> newUserInfo(@RequestBody UserInfoEntity userInfo){
        return new ResponseEntity<>(userInfoService.creatPersonalInfo(userInfo),HttpStatus.OK);
    }
    @PostMapping("/changeInfo")
    public ResponseEntity<?> changePersonalInfo(@RequestBody UserInfoEntity userInfo){
        return new ResponseEntity<>(userInfoService.changePersonalInfo(userInfo), HttpStatus.OK);
    }
}
