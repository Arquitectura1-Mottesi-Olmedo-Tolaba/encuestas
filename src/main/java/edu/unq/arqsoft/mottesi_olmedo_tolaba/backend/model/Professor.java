package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
public class Professor extends PersistenceEntity {

    private String name;

    public Professor() {
    }
    
    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
