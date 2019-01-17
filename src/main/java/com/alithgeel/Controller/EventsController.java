package com.alithgeel.Controller;
import com.alithgeel.DTO.EventsDTO;
import com.alithgeel.Entity.Events;
import com.alithgeel.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventsController {

  @Autowired
 private EventsService eventsService;


  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @RequestMapping (value = "/events")
  public List<Events> allEvents() {
    return eventsService.getAllEvents(); }


  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
  @GetMapping (value = "/event/{id}")
  public ResponseEntity getById (@PathVariable Long id) {
  return eventsService.getEventsById(id);
  }



  @PreAuthorize("hasRole('ROLE_ORGANIZER')")
  @PostMapping(value = "/event/create/{id}")
  public ResponseEntity createEvents (@RequestBody @Valid EventsDTO eventsDTO,@PathVariable @Valid Long id ,BindingResult result){
      if (result.hasErrors()){
          return ResponseEntity.badRequest().body(result.getAllErrors());
      }
    return eventsService.creatEvents(eventsDTO ,id);
  }

  @PreAuthorize("hasRole('ROLE_ORGANIZER')")
  @PutMapping(value = "/event/{id}")
  public ResponseEntity updateEvents (@RequestBody @Valid EventsDTO events,@PathVariable Long id,BindingResult result){
      if (result.hasErrors()){
          return ResponseEntity.badRequest().body(result.getAllErrors());
      }
       return eventsService.updateEvents(events,id);
  }

  @PreAuthorize("hasRole('ROLE_ORGANIZER')")
  @DeleteMapping (value = "/event/{id}")
  public void  deleteEvents (@PathVariable Long id){
    eventsService.deleteEvents(id);}


  @GetMapping(value ="/activeEvents" )
   public List<EventsDTO> allActiveEvents(){
    return eventsService.allActiveApprovedEvents(); }


    @GetMapping(value = "/nonactiveEvents")
    public List<EventsDTO> allActiveDisApprovedEvents(){
      return  eventsService.allActiveDisApprovedEvents();
    }




    @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping(value = "/approveEvent/{id}")
  public void approveEvents(@PathVariable Long id){
    eventsService.approveEvents(id);}

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping(value = "/disapproveEvent/{id}")
  public void DisapproveEvents(@PathVariable Long id){
    eventsService.DisapproveEvents(id);}


  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
  @GetMapping(value = "/event/city/{city}")
  public List<Events> search (@PathVariable(value = "city")String city)
  {return eventsService.searchInEventsByCityIgnoreCase(city);}

  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
   @GetMapping(value = "/event/date/{date}")
  public List<Events> search(@PathVariable(value = "date")Date date)
   {return eventsService.searchInEventsByDate(date);}

    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    @RequestMapping (value = "/myEvents/{orgnizerid}")
    public List<EventsDTO> myEvents(@PathVariable Long orgnizerid) {
      return eventsService.myEvents(orgnizerid);

    }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
  @GetMapping(value = "/events/{city}/{date}")
  public List<Events> searchCityDate(@PathVariable(value = "city")String city,@PathVariable(value = "date")Date date){
    return eventsService.searchInEventsByCityIgnoreCaseAndDate(city,date);
  }

}
