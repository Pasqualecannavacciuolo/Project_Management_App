package com.spring.backend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pms_3")
public class PM_3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String lastname;
    private String CF;
    private String email;
    private List<User> users_assigned;
    
    public PM_3(String name, String lastname, String CF, String email) {
        this.name = name;
        this.lastname = lastname;
        this.CF = CF;
        this.email = email;
        this.users_assigned = new ArrayList<User>();
    }
    
}
