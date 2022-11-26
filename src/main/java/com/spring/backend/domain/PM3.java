package com.spring.backend.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "pm3_id")
    private long id;
    private String name;
    private String lastname;
    private String CF;
    private String email;
    
    @ManyToOne
    PM2 pm2;

    //@ManyToMany
    /*@JoinTable(
        name = "pm3_users",
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "pm3_id")
    )*/
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "pm3_users", 
            joinColumns = { @JoinColumn(name = "pm3_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "users_id") })
    Set<User> users_assigned = new HashSet<>();

    
    public PM3(String name, String lastname, String CF, String email, PM2 pm2_new) {
        this.name = name;
        this.lastname = lastname;
        this.CF = CF;
        this.email = email;
        this.pm2 = pm2_new;
    }
    
}
