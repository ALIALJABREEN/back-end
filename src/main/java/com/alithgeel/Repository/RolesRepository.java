package com.alithgeel.Repository;

import com.alithgeel.Entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Long> {

    Roles findByRolename (String rolename);
}



