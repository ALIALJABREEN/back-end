package com.alithgeel.Controller;

import com.alithgeel.DTO.UsersDTO;
import com.alithgeel.Entity.Login;
import com.alithgeel.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class loginController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/userData")
    public ResponseEntity login(@RequestBody Login login){

        if (!usersService.isUserNameEnabled(login.getUserName())){
            throw new RuntimeException("user name is wrong");

        }
        UsersDTO usersDTO = usersService.findByUserName(login.getUserName());
        if (usersService.isUserIdEnable(usersDTO.getUsersid())&& new BCryptPasswordEncoder().matches(login.getPassword(),usersDTO.getPassword())){
            Map<String,Object>map=new HashMap<>();
            map.put("users_id",usersDTO.getUsersid());
            map.put("roleName",usersService.findByUserName(login.getUserName()).getRolename().getRolename());
            return  ResponseEntity.ok(map);
    }else{
            throw new RuntimeException("password  incorrect");
        }
    }

//    @GetMapping("/userData")
//    public ResponseEntity Login(Principal principal){
//        Map<String,String>map =new HashMap<>();
//        map.put("users_id",String.valueOf(usersService.findByUserName(principal.getName()).getUsersid()));
//        map.put("roleName",usersService.findByUserName(principal.getName()).getRolename().getRolename());
//        return  ResponseEntity.ok(map);
//    }

}
