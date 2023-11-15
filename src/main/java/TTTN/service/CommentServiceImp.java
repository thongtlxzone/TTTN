package TTTN.service;

import TTTN.dto.CommentDTO;
import TTTN.entity.CommentEntity;
import TTTN.repository.CommentRepository;
import TTTN.service.imp.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<CommentDTO> getAllCommentByTask(int taskId) {
        List<CommentEntity> list = commentRepository.getAllCommentsByTaskId(taskId);
        List<CommentDTO> listComment = new ArrayList<>();
        for (CommentEntity cmt : list) {
            CommentDTO temp = new CommentDTO();
            temp.setId(cmt.getId());
            temp.setTaskId(cmt.getTaskEntity().getId());
            temp.setContent(cmt.getContent());
            temp.setUpdate(cmt.getLastUpdate());
            temp.setUserCommentName(cmt.getUsersEntity().getFullname());
            if(cmt.getReplyComment()!=null){
                temp.setReplyTo(cmt.getReplyComment().getContent());
            }
            listComment.add(temp);
        }
        return listComment;
    }

    @Override
    public boolean comment(CommentEntity comment) {
        try{
            commentRepository.save(comment);
            return true;
        }catch (Exception e){
            System.out.println("Loi khi cmt "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCmt(CommentEntity comment, int userId) {
        CommentEntity commentChanged = commentRepository.findById(comment.getId()).get();
        if(userId==commentChanged.getUsersEntity().getId() && commentRepository.existsById(comment.getId())){
            commentChanged.setId(comment.getId());
            commentChanged.setContent(comment.getContent());
            commentRepository.save(commentChanged);
            return true;
        }else {
            System.out.println("Loi update cmt");
            return false;
        }
    }

    @Override
    public boolean deleteCmt(int cmtId, int userId) {
        try {
            if(commentRepository.existsById(cmtId) && commentRepository.findById(cmtId).get().getUsersEntity().getId()==userId){
                commentRepository.delete(commentRepository.findById(cmtId).get());
                return true;
            }else {
                System.out.println("Loi xoa cmt");
                return false;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
