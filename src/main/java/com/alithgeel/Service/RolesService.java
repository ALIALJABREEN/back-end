package com.alithgeel.Service;

import com.alithgeel.Entity.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RolesService {
    public List<Roles> getAllRoles();
    public Roles getRolesById(Long id);
    public void  saveOrUpdate(Roles roles);
    public void deleteUsers(Long id);

}
