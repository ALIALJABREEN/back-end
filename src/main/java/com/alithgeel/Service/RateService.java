package com.alithgeel.Service;

import com.alithgeel.Entity.Rate;
import org.springframework.http.ResponseEntity;

public interface RateService {

//    public List<Rate> getAllReview();
//    public Rate getReviewById(Long id);
//    public void  saveOrUpdate(Rate review);
//    public void deleteReview(Long id);

     public ResponseEntity rateEvent(Long ticket_id, Rate rate);
}
