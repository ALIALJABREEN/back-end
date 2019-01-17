package com.alithgeel.Service;

import com.alithgeel.DTO.UsersDTO;
import com.alithgeel.Entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsersService {
    public List<UsersDTO> getAllUsers();
    public Users getUserById(Long id);
    public Users crateUsers(UsersDTO usersDTO);
    public void   updateUsers(UsersDTO usersDTO, Long usersid);
    public void deleteUsers(Long id);
    public void enableUsers(Long id);
    public UsersDTO findByUserName(String userName);
}
