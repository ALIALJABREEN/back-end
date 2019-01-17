package com.alithgeel.Service;

import com.alithgeel.Entity.Comment;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface CommentService {

    public ResponseEntity Create (Long users_id, Long event_id,Comment comment);

    List<Comment> getComments(Long event_id);

    List<Comment> findAll();
}
