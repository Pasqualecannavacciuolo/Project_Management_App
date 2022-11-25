package com.spring.backend.domain;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany
    @JoinColumn(name = "pm2_id")
    @JsonIgnore
    private Set<PM3> pms3_assigned;
    
    public PM2(String name, String lastname, String CF, String email) {
        this.name = name;
        this.lastname = lastname;
        this.CF = CF;
        this.email = email;
    }
    
}
