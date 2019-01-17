package com.alithgeel.Service;

import com.alithgeel.DTO.UsersDTO;
import com.alithgeel.Entity.Users;
import com.alithgeel.ObjectMapperUtils;
import com.alithgeel.Repository.RolesRepository;
import com.alithgeel.Repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService  {

    @Autowired
    public UsersRepository usersRepository;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public RolesRepository rolesRepository;



    @Override
    public List<UsersDTO> getAllUsers() {
         List<Users> users = usersRepository.findAll();
         List<UsersDTO> usersDTOS = ObjectMapperUtils.mapAll(users,UsersDTO.class);
         return usersDTOS;
    }


    @Override
    public Users getUserById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Users crateUsers(UsersDTO usersDTO) {
        if (!usersRepository.existsByUserName(usersDTO.getUserName())) {
            if (!usersRepository.existsByEmail(usersDTO.getEmail())) {
                usersDTO.setRolename(rolesRepository.findByRolename(usersDTO.getRole()));
                Users users = modelMapper.map(usersDTO, Users.class);
                String encoded = new BCryptPasswordEncoder().encode(users.getPassword());
                users.setPassword(encoded);
                return usersRepository.save(users);
            }
            throw new RuntimeException("this email"+ usersDTO.getEmail()+"already exist");
        }
        throw new RuntimeException("this user"+usersDTO.getUserName()+" already exist");
    }

    @Override
    public void updateUsers(UsersDTO usersDTO, Long usersid){

        if (usersRepository.findById(usersid).isPresent()) {
            Users tempUsersEntity = usersRepository.findById(usersid).get();
            Users users=modelMapper.map(usersDTO,Users.class);
            users.setRolename(tempUsersEntity.getRolename());
            users.setUsers_id(usersid);
            String encoded =new BCryptPasswordEncoder().encode(users.getPassword());
            users.setPassword(encoded);
            users.setEnabled(true);
            usersRepository.save(users);

        }

    }




    @Override
    public void deleteUsers(Long id) {
        Users user = usersRepository.findById(id).get();
       user.setEnabled(false);
        usersRepository.save(user);
    }

    @Override
    public void enableUsers(Long id) {
        Users users=usersRepository.findById(id).get();
        users.setEnabled(true);
        usersRepository.save(users);
    }
    @Override
    public UsersDTO findByUserName(String userName){
        Users users = usersRepository.findByUserName(userName);
        UsersDTO usersDTO = modelMapper.map(users,UsersDTO.class);
        return usersDTO;
    }
}
