package TTTN.controller;

import TTTN.service.imp.HistoryActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("history")
public class HistoryActionController {
    @Autowired
    HistoryActionService historyActionService;
    @PostMapping("/getHistory")
    public ResponseEntity<?> getHistory(@RequestParam int userId){
        return new ResponseEntity<>(historyActionService.getAllHistoryActionByUserId(userId), HttpStatus.OK);
    }
}
