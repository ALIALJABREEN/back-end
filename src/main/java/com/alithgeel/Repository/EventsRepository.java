package com.alithgeel.Repository;

import com.alithgeel.DTO.EventsDTO;
import com.alithgeel.Entity.Events;
import com.alithgeel.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {

        List<Events> findByApprovedTrueAndDeletingFalseAndDateAfter(Date date);
        List<Events> findByApprovedFalseAndDeletingFalseAndDateAfter(Date date);
        List<Events> findByCityIgnoreCase(String city);
        List<Events> findByDateIn(Date date);
        List<Events> findByCityIgnoreCaseAndDateIn(String city ,Date date);
        List<Events> findByUsersAndDeletingIsFalse (Users users);
}
