package com.alithgeel.Service;

import com.alithgeel.DTO.EventsDTO;
import com.alithgeel.Entity.Events;
import org.springframework.http.ResponseEntity;
import java.sql.Date;
import java.util.List;

public interface EventsService {
    public List<Events> getAllEvents();
    public ResponseEntity getEventsById(Long id);
    public ResponseEntity  creatEvents(EventsDTO eventsDTO,Long users_id);
    public ResponseEntity updateEvents(EventsDTO eventsDTO,Long id);
    public void deleteEvents(Long id);

    public List<EventsDTO> allActiveApprovedEvents();
    public List<EventsDTO> allActiveDisApprovedEvents();
    List<EventsDTO> myEvents(Long orgnizerid);
    public void  approveEvents(Long id);
    public void  DisapproveEvents(Long id);

    public List<Events> searchInEventsByCityIgnoreCase(String city);
    public List<Events> searchInEventsByDate(Date date);
    public List<Events> searchInEventsByCityIgnoreCaseAndDate(String city ,Date date);

   }
