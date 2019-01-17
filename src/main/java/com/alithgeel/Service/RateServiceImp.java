package com.alithgeel.Service;

import com.alithgeel.Entity.Rate;
import com.alithgeel.Entity.Tickets;
import com.alithgeel.Repository.RateRepository;
import com.alithgeel.Repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImp implements RateService {

    @Autowired
    public RateRepository rateRepository;
    @Autowired
    public TicketsRepository ticketsRepository;


    @Override
    public ResponseEntity rateEvent(Long ticket_id,Rate rate) {
        if (ticketsRepository.findById(ticket_id).isPresent()) {
            Tickets tickets =  ticketsRepository.findById(ticket_id).get();
            if (tickets.isAttend()) {
                rate.setTickets(tickets);
                tickets.setComment(rate.getComments());
                tickets.setRate(rate.getRate());
                tickets.setRated(true);
                rateRepository.save(rate);
                return ResponseEntity.ok(rate);
            }
        }
        return new ResponseEntity("Ticket id not found",HttpStatus.NOT_FOUND);
    }








//    @Override
//    public List<Rate> getAllReview() {
//        return (List<Rate>) reviewRepository.findAll();
//    }
//
//    @Override
//    public Rate getReviewById(Long id) {
//        return reviewRepository.findById(id).get();
//    }
//
//    @Override
//    public void saveOrUpdate(Rate review) {
//        reviewRepository.save(review);
//    }
//
//    @Override
//    public void deleteReview(Long id) {
//        Rate review = reviewRepository.findById(id).get();
//        review.setIs_delete(true);
//        reviewRepository.save(review);
//    }

}