package TTTN.controller;

import TTTN.entity.CommentEntity;
import TTTN.service.imp.CommentService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/commemt")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/CmtOfTask")
    public ResponseEntity<?> getAllCommentsOfTask(@RequestParam int taskId){
        return new ResponseEntity<>(commentService.getAllCommentByTask(taskId), HttpStatus.OK);
    }
    @PostMapping("/createComment")
    public ResponseEntity<?> comment(@RequestBody CommentEntity comment){
        return new ResponseEntity<>(commentService.comment(comment),HttpStatus.OK);
    }
    @PostMapping("/updateComment")
    public ResponseEntity<?> updateCmt(@RequestBody CommentEntity comment, @RequestParam int userId){
        return new ResponseEntity<>(commentService.updateCmt(comment,userId),HttpStatus.OK);
    }
    @PostMapping("/deleteComment")
    public ResponseEntity<?> deleteCmt(@RequestParam int cmtId, @RequestParam int userId){
        return new ResponseEntity<>(commentService.deleteCmt(cmtId,userId),HttpStatus.OK);
    }
}
