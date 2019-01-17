package com.alithgeel.Service;

import com.alithgeel.Entity.Roles;
import com.alithgeel.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolesServiceImp implements RolesService {


    @Autowired

    public RolesRepository rolesRepository;

    @Override
    public List<Roles> getAllRoles() {
        return (List<Roles> ) rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Long id) {
        return rolesRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Roles roles) {
     rolesRepository.save(roles);
    }

    @Override
    public void deleteUsers(Long id) {
    Roles roles=rolesRepository.findById(id).get();
    roles.setIs_delete(false);
    rolesRepository.save(roles);
    }
}
