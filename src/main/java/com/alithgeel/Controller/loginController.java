package com.alithgeel.Controller;

import com.alithgeel.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class loginController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/userData")
    public ResponseEntity login(Principal principal){
        Map<String,String>map =new HashMap<>();
        map.put("users_id",String.valueOf(usersService.findByUserName(principal.getName()).getUsers_id()));
        map.put("roleName",usersService.findByUserName(principal.getName()).getRolename().getRolename());
        return  ResponseEntity.ok(map);
    }

}
