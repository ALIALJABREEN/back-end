package com.alithgeel.Controller;

import com.alithgeel.Entity.Tickets;
import com.alithgeel.Service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
//
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/tickets")
    public List<Tickets> all() {
        return ticketsService.getAllTickets();
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/ticket/{id}")
    public Tickets getById (@PathVariable Long id ) {
        return  ticketsService.getTicketsById(id);
    }


    @PostMapping(value = "/updateticket/{id}")
    public void update (@RequestBody Tickets tickets,@PathVariable Long id) {
        ticketsService.UpdateTicket(tickets,id);
    }



    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping(value = "/ticket/{id}")
    public ResponseEntity  delete (@PathVariable Long id) {
        return ticketsService.deleteTickets(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ORGANIZER,ROLE_USER')")
    @GetMapping(value = "/approveticket/{id}")
    public void  approve(@PathVariable Long id){
         ticketsService.approveTicket(id);
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/bookticket/{users_id}/{event_id}")
    public ResponseEntity book(@Valid @PathVariable Long users_id,@Valid @PathVariable Long event_id) {
        return  ticketsService.BookTickets(users_id,event_id );
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/mytickets/{id}")
    public List<Tickets> myTicket(@PathVariable Long id) {
        return ticketsService.findAllMyBookedTicket(id);
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/mytickets/attend/{id}")
    public List<Tickets> myTicketAttend(@PathVariable Long id) {
        return ticketsService.findMyBookedTicket(id);
    }




    @PreAuthorize("hasAnyRole('ROLE_ORGANIZER')")
   @GetMapping(value = "/eventsticket/{event_id}")
   public List<Tickets> getEventsTickets( @PathVariable Long event_id) {
        return ticketsService.getEventsTickets(event_id);
   }

    // just fot testing
    @GetMapping("/count/{userid}/{eventid}")
    public Long Counter ( @PathVariable Long userid,@PathVariable Long eventid){
        return ticketsService.Counter(userid,eventid);
    }
}