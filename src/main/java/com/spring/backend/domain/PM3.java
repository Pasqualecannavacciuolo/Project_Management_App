package com.spring.backend.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok methods
@Getter @Setter @NoArgsConstructor

@Entity
@Table(name="pms3")
public class PM3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String lastname;
    private String CF;
    private String email;
    
    @ManyToOne
    //@JoinColumn(name = "pm2_id")
    PM2 pm2;

    
    public PM3(String name, String lastname, String CF, String email, PM2 pm2_new) {
        this.name = name;
        this.lastname = lastname;
        this.CF = CF;
        this.email = email;
        this.pm2 = pm2_new;
    }
    
}
