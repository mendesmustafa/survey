package com.mendes.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mendes
 */

@Entity
@Table(name = "POLLSTER")
public class Pollster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "POLLSTER_ID_SEQ")
    @SequenceGenerator(name = "POLLSTER_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
