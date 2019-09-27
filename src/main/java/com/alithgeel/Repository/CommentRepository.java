package com.alithgeel.Repository;

import com.alithgeel.Entity.Comment;
import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Tickets;
import com.alithgeel.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findByUsers(Users users);

    List<Comment> findAllByEventsAndDeletingIsFalse(Events events);
   Long countByEventsAndUsersAndLocalDateTimeIsAfter(Events events, Users users, LocalDateTime localDateTime);

}
