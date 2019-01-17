package com.alithgeel.DTO;

import com.alithgeel.Entity.Roles;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsersDTO {

    @Id
    private Long users_id;

    @NotNull(message = "The user name must not be Null")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Pattern(regexp = "[a-zA-Z0-9]{2,25}",message = "can not have symboles or numbers")
    @Size(min = 2, max = 25 ,message = "user name must be between 2 - 25 leeter")
    private String userName;


    @NotNull(message ="The First Name must not be Null")
    @Pattern(regexp = "[a-zA-Z]{2,10}",message = "can not have symboles or numbers ")
    @Size(min = 2, max = 10, message = "first name must be  between 2 - 10")
    private  String  firstName;


    @NotNull(message = "The Last Name must not be Null")
    @Pattern(regexp = "[a-zA-Z]{2,15}",message = "can not have symboles or numbers ")
    @Size(min = 2, max = 15, message = "the Last Name must be between 2 to 15 characters")
    private  String lastName;


    @NotNull(message ="The  password must not be Null")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Pattern(regexp = "[a-zA-Z0-9]{8,20}",message = "password must be more than 8 digits and less than 20")
    @Size(min = 8,message = "password must be more than 8 digits and less than 20")
    private String password;


    @NotNull(message = "The Email must not be Null ")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Email
    @Size(max = 40)
    private  String email;


    @NotNull(message = "The Mobile Number must not be Null")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Pattern(regexp = "[5]{1}+[0-9]{8}",message = "mobile number must be 9 number")
    @Size(min = 9, max = 9, message = "The mobile number must be 9 numbers")
    private String mobileNumber;


    private String gender;
    private boolean enabled;
    private Roles rolename;
    private String role;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Roles getRolename() {
        return rolename;
    }

    public void setRolename(Roles rolename) {
        this.rolename = rolename;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
