package com.alithgeel.Controller;

import com.alithgeel.Entity.Roles;
import com.alithgeel.Repository.RolesRepository;
import com.alithgeel.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/Roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

  @RequestMapping(value = "/all") public List<Roles> all() {
      return rolesService.getAllRoles();
  }
  @GetMapping (value = "/{id}") public Roles getById (@PathVariable Long id){
      return rolesService.getRolesById(id);
  }
  @PostMapping(value = "/create") public void create(@RequestBody Roles roles){
      rolesService.saveOrUpdate(roles);
  }
}