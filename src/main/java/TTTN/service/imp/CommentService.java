package TTTN.service.imp;

import TTTN.dto.CommentDTO;
import TTTN.entity.CommentEntity;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllCommentByTask(int taskId);
    boolean comment(CommentEntity comment);
    boolean updateCmt(CommentEntity comment, int userId);
    boolean deleteCmt(int cmtId, int userId);
}
