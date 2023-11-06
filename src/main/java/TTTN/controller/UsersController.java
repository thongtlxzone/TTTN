package TTTN.controller;

import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import TTTN.payload.LoginRequest;
import TTTN.service.imp.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/userdata")
    public ResponseEntity<?> userdata(@RequestParam int userId){
        return new ResponseEntity<>(usersService.userdata(userId),HttpStatus.OK);
    }
    @PostMapping("/admin")
    public ResponseEntity<?> getAllUsers(@RequestParam int userId){
        return new ResponseEntity<>(usersService.getAllUsers(userId),HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(usersService.login(loginRequest.getUsername(),loginRequest.getPassword()), HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UsersEntity usersEntity){
        return new ResponseEntity<>(usersService.signup(usersEntity),HttpStatus.OK);
    }
    @PostMapping("/information")
    public ResponseEntity<?> showinfo(@RequestParam int userId){
        return new ResponseEntity<>(usersService.showinfo(userId),HttpStatus.OK);
    }
    @PostMapping("/changeInfomation")
    public ResponseEntity<?> changeInfomation(@RequestBody UsersEntity usersEntity){
        return new ResponseEntity<>(usersService.changeInformation(usersEntity),HttpStatus.OK);
    }
    @PostMapping("/searchUser")
    public ResponseEntity<?> searchUserByName(@RequestParam String userName){
        return new ResponseEntity<>(usersService.searchUserByName(userName),HttpStatus.OK);
    }
}
