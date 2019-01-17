package com.alithgeel.Service;

import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Tickets;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketsService {
    public List<Tickets> getAllTickets();
    public Tickets getTicketsById(Long id);
    public void  UpdateTicket(Tickets tickets,Long ticket_id);

    public ResponseEntity deleteTickets(Long id);
    public List<Tickets> findAllMyBookedTicket(Long id);

    public List<Tickets> findMyBookedTicket(Long id);
     List<Tickets> getEventsTickets (Long event_id);


    public ResponseEntity BookTickets(Long users_id, Long event_id);
    public void  approveTicket(Long id);
    public Long Counter (Long users_id,Long event_id);
}
