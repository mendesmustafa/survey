package com.mendes.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author mendes
 */

@Entity
@Table(name = "LIFESURVEY")
public class LifeSurvey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "LİFESURVEY_ID_SEQ")
    @SequenceGenerator(name = "LİFESURVEY_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "GENDER")
    private int gender;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "HAPPINESS_RATE")
    private int happinessRate;

    @Column(name = "HAPPY_THING")
    private String happyThing;

    @Column(name = "UNHAPPY_THING")
    private String unhappyThing;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pollster_id")
    private Pollster pollster;


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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHappinessRate() {
        return happinessRate;
    }

    public void setHappinessRate(int happinessRate) {
        this.happinessRate = happinessRate;
    }

    public String getHappyThing() {
        return happyThing;
    }

    public void setHappyThing(String happyThing) {
        this.happyThing = happyThing;
    }

    public String getUnhappyThing() {
        return unhappyThing;
    }

    public void setUnhappyThing(String unhappyThing) {
        this.unhappyThing = unhappyThing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pollster getPollster() {
        return pollster;
    }

    public void setPollster(Pollster pollster) {
        this.pollster = pollster;
    }
}
