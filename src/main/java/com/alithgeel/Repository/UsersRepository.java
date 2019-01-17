package com.alithgeel.Repository;

import com.alithgeel.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

Users findByUserName(String userName);
boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
