package com.alithgeel.Controller;

import com.alithgeel.Entity.Comment;
import com.alithgeel.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ORGANIZER','ROLE_ADMIN')")
    @GetMapping("/comments/{event_id}")
    public List<Comment> getComments( @PathVariable Long event_id){
        return commentService.getComments(event_id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ORGANIZER','ROLE_ADMIN')")
    @PostMapping("/comment/{users_id}/{event_id}")
    public ResponseEntity Create(@PathVariable Long users_id, @PathVariable Long event_id,@RequestBody @Valid Comment comment){
        return commentService.Create(users_id,event_id,comment);
    }



    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
    @GetMapping("/all")
    private List<Comment> findALL () {
        return commentService.findAll();
    }
}
