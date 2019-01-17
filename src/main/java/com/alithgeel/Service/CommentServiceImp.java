package com.alithgeel.Service;
import com.alithgeel.Entity.Comment;
import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Users;
import com.alithgeel.Repository.CommentRepository;
import com.alithgeel.Repository.EventsRepository;
import com.alithgeel.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EventsRepository eventsRepository ;


    @Override
    public ResponseEntity Create( Long users_id, Long event_id,Comment comment) {

        Users users = usersRepository.findById(users_id).get();
        Events events = eventsRepository.findById(event_id).get();

        LocalDateTime dateTime = LocalDateTime.now().minusSeconds(30);
        long count = commentRepository.countByEventsAndUsersAndLocalDateTimeIsAfter(events, users, dateTime);
        if (count == 0) {
            comment.setEvents(events);
            comment.setUsers(users);
            comment.setLocalDateTime(LocalDateTime.now());
            commentRepository.save(comment);
            return   ResponseEntity.ok(comment);
        }
        throw new RuntimeException("You can not add two comment between 30 second");
    }

    @Override
    public List<Comment> getComments(Long event_id) {
        Events events =eventsRepository.findById(event_id).get();
        return commentRepository.findAllByEventsAndDeletingIsFalse(events);
    }


    @Override
    public List<Comment> findAll() {

        return (List<Comment>) commentRepository.findAll();
    }
}
