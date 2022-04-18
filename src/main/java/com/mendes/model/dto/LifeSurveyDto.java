package com.mendes.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author mendesmustafa on 17-04-2022
 */

public class LifeSurveyDto implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private int gender;
    private LocalDate dateOfBirth;
    private int happinessRate;
    private String happyThing;
    private String unhappyThing;
    private String description;
    private PollsterDto pollster;

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

    public PollsterDto getPollster() {
        return pollster;
    }

    public void setPollster(PollsterDto pollster) {
        this.pollster = pollster;
    }
}
