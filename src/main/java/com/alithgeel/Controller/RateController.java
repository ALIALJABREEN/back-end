package com.alithgeel.Controller;

import com.alithgeel.Entity.Rate;
import com.alithgeel.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RateController {


    @Autowired
    private RateService rateService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
    @PostMapping(value = "/rate/{ticket_id}")
    public ResponseEntity rateEvent( @Valid@PathVariable Long ticket_id,@Valid@RequestBody Rate rate) {
        return rateService.rateEvent(ticket_id,rate);
    }












//    @RequestMapping (value = "/all")
//    public List<Rate> all() {
//        return rateService.getAllReview();
//    }
//
//
//    @GetMapping(value = "/{id}")
//    public Rate getById (@PathVariable Long id) {
//        return rateService.getReviewById(id);
//    }
//
//
//    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ORGANIZER')")
//    @PostMapping(value = "/create")
//    public void create (@RequestBody Rate review) {
//        rateService.saveOrUpdate(review);
//    }
//
//
//    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ORGANIZER')")
//    @PutMapping (value = "/delete/{id}")
//    public void  delete (@PathVariable Long id){
//        rateService.deleteReview(id);
//    }

}
