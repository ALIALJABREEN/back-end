package com.alithgeel.Service;

import com.alithgeel.DTO.EventsDTO;
import com.alithgeel.Entity.EmailSender;
import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Tickets;
import com.alithgeel.Entity.Users;
import com.alithgeel.ObjectMapperUtils;
import com.alithgeel.Repository.EventsRepository;
import com.alithgeel.Repository.TicketsRepository;
import com.alithgeel.Repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class EventsServiceImp implements EventsService {

    @Autowired
    public EventsRepository eventsRepository;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    public TicketsRepository ticketsRepository;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public UsersRepository usersRepository;



    @Override
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }


    @Override
    public ResponseEntity getEventsById(Long id) {
        if (eventsRepository.findById(id).isPresent()) {
            Events events = eventsRepository.findById(id).get();
            EventsDTO eventsDTO = modelMapper.map(events, EventsDTO.class);
            return ResponseEntity.ok(eventsDTO) ;
        }
        return new ResponseEntity("Event id not found",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity creatEvents(EventsDTO eventsDTO,Long users_id) {
        Date date=Date.valueOf(LocalDate.now().minusDays(1));
        if (eventsDTO.getDate().after(date)) {
            Events events = modelMapper.map(eventsDTO, Events.class);
            events.setUsers(usersRepository.findById(users_id).get());
             return ResponseEntity.ok(eventsRepository.save(events));
        }
        return new  ResponseEntity("You should Enter valid date",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateEvents(EventsDTO eventsDTO, Long id) {

        if (eventsRepository.findById(id).isPresent()) {
            Events tempEventEntity =eventsRepository.findById(id).get();
            Events events =modelMapper.map(eventsDTO,Events.class);
            events.setEvent_id(id);
            events.setUsers(tempEventEntity.getUsers());
            eventsRepository.save(events);
            List<Tickets> tickets =ticketsRepository.findAllByEventsAndDeletingFalse(events);
//            for (Tickets tickets1:tickets)
//                emailSender.sendSimpleMessage(tickets1.getUsers().getEmail(),
//                        "all the users","Update The event the event will be at 9pm");
            return ResponseEntity.ok(events);
        }
        return new ResponseEntity("Event id not found",HttpStatus.NOT_FOUND);
        }



    @Override
    public void deleteEvents(Long id) {

        Events events = eventsRepository.findById(id).get();
        events.setDeleting(true);
        eventsRepository.save(events);
        List<Tickets> tickets = ticketsRepository.findAllByEventsAndDeletingFalse(events);
//        for (Tickets tickets1 : tickets)
//            emailSender.sendSimpleMessage(tickets1.getUsers().getEmail(),
//                    "all the users", "Update The event the event will be at 9pm");
    }


    @Override
    public List<EventsDTO> allActiveApprovedEvents() {

       Date date = Date.valueOf(LocalDate.now().minusDays(1));
        List<Events> eventsList = eventsRepository.findByApprovedTrueAndDeletingFalseAndDateAfter(date);
        List<EventsDTO> eventsDTOS = ObjectMapperUtils.mapAll(eventsList ,EventsDTO.class);
        return eventsDTOS;
    }

    @Override
    public List<EventsDTO> allActiveDisApprovedEvents() {
        Date date = Date.valueOf(LocalDate.now().minusDays(1));
        List<Events> eventsList = eventsRepository.findByApprovedFalseAndDeletingFalseAndDateAfter(date);
        List<EventsDTO> eventsDTOS = ObjectMapperUtils.mapAll(eventsList ,EventsDTO.class);
        return eventsDTOS;
    }




    @Override
    public List<EventsDTO> myEvents(Long orgnizerid) {
        Users users=usersRepository.findById(orgnizerid).get();
        List<Events> events=eventsRepository.findByUsersAndDeletingIsFalse(users);
        List<EventsDTO> eventsDTOS=ObjectMapperUtils.mapAll(events ,EventsDTO.class);
        return eventsDTOS;
    }


    @Override
    public void approveEvents(Long id) {
        Events events = eventsRepository.findById(id).get();
        events.setApproved(true);
        eventsRepository.save(events);
    }

    @Override
    public void DisapproveEvents(Long id) {
        Events events = eventsRepository.findById(id).get();
        events.setApproved(false);
        eventsRepository.save(events);
    }






    @Override
    public List<Events> searchInEventsByCityIgnoreCase(String city){
        Date date = Date.valueOf(LocalDate.now().minusDays(1));
        return eventsRepository.findByCityIgnoreCase(city);
    }


    @Override
    public List<Events> searchInEventsByDate(Date date) {
        return  eventsRepository.findByDateIn(date);
    }

    @Override
    public List<Events> searchInEventsByCityIgnoreCaseAndDate(String city,Date date) {
        return eventsRepository.findByCityIgnoreCaseAndDateIn(city, date);
    }

}