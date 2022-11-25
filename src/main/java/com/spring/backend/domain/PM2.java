package com.spring.backend.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok methods
@Getter @Setter @NoArgsConstructor

@Entity
@Table(name="pms2")
public class PM2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String lastname;
    private String CF;
    private String email;
    private ArrayList<PM2> pms3_assigned;
    
    public PM2(String name, String lastname, String CF, String email) {
        this.name = name;
        this.lastname = lastname;
        this.CF = CF;
        this.email = email;
        this.pms3_assigned = new ArrayList<PM2>();
    }
    
}
