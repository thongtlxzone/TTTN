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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(usersService.login(loginRequest.getUsername(),loginRequest.getPassword()), HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UsersEntity usersEntity){
        return new ResponseEntity<>(usersService.signup(usersEntity),HttpStatus.OK);
    }
    @PostMapping("/infomation")
    public ResponseEntity<?> showinfo(@RequestParam String username){
        return new ResponseEntity<>(usersService.showinfo(username),HttpStatus.OK);
    }
    @PostMapping("/changeInfomation")
    public ResponseEntity<?> changeInfomation(@RequestBody UsersEntity usersEntity){
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
