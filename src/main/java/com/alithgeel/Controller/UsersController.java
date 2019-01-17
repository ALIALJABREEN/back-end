package com.alithgeel.Controller;

import com.alithgeel.DTO.UsersDTO;
import com.alithgeel.Entity.Users;
import com.alithgeel.Repository.RolesRepository;
import com.alithgeel.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RolesRepository rolesRepository;


    @RequestMapping(value = "/users")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UsersDTO> all() {
        return usersService.getAllUsers();
    }


//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/user/{id}")
    public Users getById(@PathVariable Long id){
        return usersService.getUserById(id);
    }



    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/user/admin")
    public ResponseEntity addAdmin (@RequestBody @Valid UsersDTO usersDTO,BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        usersDTO.setRolename(rolesRepository.findByRolename("ROLE_ADMIN"));
        return ResponseEntity.ok(usersService.crateUsers(usersDTO)) ;
    }


    @PostMapping(value = "/user")
    public void addUser (@RequestBody @Valid UsersDTO usersDTO, BindingResult result){
        if (result.hasErrors()){
             ResponseEntity.badRequest().body(result.getAllErrors());
        }
         ResponseEntity.ok(usersService.crateUsers(usersDTO)) ;
    }



    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
    @PutMapping(value = "/user/{usersid}")
    public ResponseEntity update (@RequestBody @Valid UsersDTO usersDTO, @PathVariable Long usersid,BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        usersService.updateUsers(usersDTO,usersid);
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')")
    @DeleteMapping (value = "/user/{id}")
    public void delete (@PathVariable Long id) {
        usersService.deleteUsers(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value ="/user/enable/{id}")
    public void enableUsers(@PathVariable Long id){
        usersService.enableUsers(id);
    }
}

