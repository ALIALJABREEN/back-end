package com.alithgeel.Service;

import com.alithgeel.Entity.EmailSender;
import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Tickets;
import com.alithgeel.Entity.Users;
import com.alithgeel.Repository.EventsRepository;
import com.alithgeel.Repository.TicketsRepository;
import com.alithgeel.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketsServiceImp implements TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EmailSender emailSender;



    @Override
    public List<Tickets> getAllTickets() {
        return (List<Tickets>) ticketsRepository.findAll();
    }
    @Override
    public Tickets getTicketsById(Long id) {
        return ticketsRepository.findById(id).get();
    }
    @Override
    public void UpdateTicket(Tickets tickets,Long ticket_id) {
        ticketsRepository.save(tickets);
    }



    @Override
    public ResponseEntity BookTickets(@Valid Long users_id , @Valid  Long event_id) {
        if (eventsRepository.findById(event_id).isPresent() && usersRepository.findById(users_id).isPresent()) {
            Tickets tickets = new Tickets();
            Date date = Date.valueOf(LocalDate.now().minusDays(1));
            Events events = eventsRepository.findById(event_id).get();
            Users users = usersRepository.findById(users_id).get();
            if (ticketsRepository.countByUsersAndTicketdate(users, events.getDate()) ==1) {
               throw new RuntimeException("you can not book two ticket in same time");
            }

            if (events.isApproved() && !events.isDeleting() && events.getDate().after(date) && events.getCount() < events.getCapacity()) {
                tickets.setEvents(eventsRepository.findById(event_id).get());
                tickets.setUsers(usersRepository.findById(users_id).get());
                tickets.setTicketdate(events.getDate());
                tickets.setTickettime(events.getTime());
                tickets.setEvent_name(events.getEvent_name());
                events.setCount(events.getCount() + 1);
                tickets.setAttend(false);
                ticketsRepository.save(tickets);
//               emailSender.sendSimpleMessage(tickets.getUsers().getEmail(),
//                        "all the users", "Thank you for Regestration in "+events.getEvent_name());
                return  ResponseEntity.ok(tickets);
            }
            return new ResponseEntity("Events is not active or event is full",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Event id or User id not found",HttpStatus.NOT_FOUND);
    }

    @Override
    public void approveTicket(Long id) {
        Tickets tickets=ticketsRepository.findById(id).get();
        tickets.setAttend(true);
        ticketsRepository.save(tickets);
    }

    @Override
    public List<Tickets> findAllMyBookedTicket(Long id ) {
        Users users=usersRepository.findById(id).get();
        return ticketsRepository.findAllByUsersAndDeletingFalseAndAttendFalse(users);
    }

    @Override
    public List<Tickets> findMyBookedTicket(Long id ) {
        Users users=usersRepository.findById(id).get();
        return ticketsRepository.findAllByUsersAndDeletingFalseAndAttendTrue(users);
    }


    @Override
      public List<Tickets> getEventsTickets(Long event_id) {
      Events events=eventsRepository.findById(event_id).get();
      return ticketsRepository.findAllByEventsAndDeletingFalse(events);
    }

    @Override
    public ResponseEntity deleteTickets(Long id) {
        if (ticketsRepository.findById(id).isPresent()){
            Tickets tickets =ticketsRepository.findById(id).get();
            tickets.setDeleting(true);
            tickets.getEvents().setCount(tickets.getEvents().getCount()-1);
            ticketsRepository.save(tickets);
//            emailSender.sendSimpleMessage(tickets.get().getUsers().getEmail(),
//                    "all the users", "your Ticket is Canceld");
            return   ResponseEntity.ok().build();
        }
        return new ResponseEntity("Ticket Id not found",HttpStatus.NOT_FOUND);
    }






    @Override
    public Long Counter (Long userid,Long eventid) {
        Events events = eventsRepository.findById(eventid).get();
        return ticketsRepository.countByUsersAndTicketdate(usersRepository.findById(userid).get(),events.getDate());
    }
}
