package com.alithgeel.Repository;

import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Tickets;
import com.alithgeel.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface TicketsRepository extends CrudRepository<Tickets,Long> {
    //As Attender,I can book tickets from all active event .
    List<Tickets> findByUsersAndDeletingFalse(Users users);

    Long countByUsersAndTicketdate(Users users, Date eventdate);

    // Attender can cancel  booked ticket
    List<Tickets> findAllByUsersAndDeletingFalseAndAttendFalse(Users users);
    List<Tickets> findAllByUsersAndDeletingFalseAndAttendTrue(Users users);

    List<Tickets> findAllByEventsAndDeletingFalse(Events events);

}
