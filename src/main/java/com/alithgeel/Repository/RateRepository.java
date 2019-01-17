package com.alithgeel.Repository;

import com.alithgeel.Entity.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate,Long> {
}
