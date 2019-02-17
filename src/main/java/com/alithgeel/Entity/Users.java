package com.alithgeel.Entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Users_id")
    private Long usersid;


    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Pattern(regexp = "[a-zA-Z0-9]{2,25}",message = "can not have symboles or numbers")
    @Size(min = 2, max = 25 ,message = "user name must be between 2 - 25 leeter")
    @NotNull(message = "The UserName must not be Null")
    @Column(name = "username",unique = true)
    private String userName;



    @Pattern(regexp = "[a-zA-Z]{2,10}",message = "can not have symboles or numbers ")
    @Size(min = 2, max = 10, message = "first name must be  between 2 - 10")
    @NotNull(message = "The First Name must not be Null")
    @Column(name = "First_name")
    private String firstName;



    @Pattern(regexp = "[a-zA-Z]{2,15}",message = "can not have symboles or numbers")
    @Size(min = 2, max = 15, message = "the Last Name must be between 2 to 15 characters")
    @NotNull(message = "The Last Name must not be Null")
    @Column(name = "Last_name")
    private String lastName;

    @NotNull(message = "The First Name must not be Null")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
//    @Pattern(regexp = "[a-zA-Z0-9]{8,25}",message = "password must be more than 8 digits and less than 20")
    @Size(min = 8,message = "password must be more than 8 digits and less than 20")
    @Column(name = "password")
    private String password;

    @NotNull(message = "The Email must not be Null ")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Email
    @Size(max = 40)
    @Column(name = "Email",unique = true)
    private String email;


    @NotNull(message = "The Mobile Number must not be Null")
    @Pattern(regexp = "[^\\s]+",message = "whitespace not accepted")
    @Pattern(regexp = "[5]{1}+[0-9]{8}",message = "mobile number must be 9 number")
    @Size(min = 9, max = 9, message = "The Password must be 9 numbers")
    @Column(name = "Mobile_number")
    private String mobileNumber;

    @NotNull(message = "The Gender must not be Null")
    @Column(name = "Gender")
    private String gender;

    @Size(min = 1, max = 15, message = "The Address must be between 1 to 15 characters")
    @Column(name = "Address")
    private String address;


    @Column(name = "enabled")
    private boolean enabled;


    @ManyToOne
    @JoinColumn(name = "rolename", referencedColumnName = "rolename")
    private Roles rolename;







    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Roles getRolename() {
        return rolename;
    }

    public void setRolename(Roles rolename) {
        this.rolename = rolename;
    }
}