package com.alithgeel.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="Roles")
public class Roles {

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
//    @Column(Rolename = "Roles_id")
//    private Long roles_id;
    @Id
    @Column(name = "rolename")
    private String rolename;

    @JsonIgnore
    @Column(name = "Is_delete")
    private boolean is_delete;







    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    //    public Long getRoles_id() {
//        return roles_id;
//    }
//
//    public void setRoles_id(Long roles_id) {
//        this.roles_id = roles_id;
//    }

}