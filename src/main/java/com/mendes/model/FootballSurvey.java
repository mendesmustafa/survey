package com.mendes.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author mendes
 */

@Entity
@Table(name = "FOOTBALLSURVEY")
public class FootballSurvey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "FOOTBALLSURVEY_ID_SEQ")
    @SequenceGenerator(name = "FOOTBALLSURVEY_ID_SEQ", allocationSize = 1)
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

    @Column(name = "FAVORITE_FOOTBALL_TEAM")
    private String favoriteFootballTeam;

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

    public String getFavoriteFootballTeam() {
        return favoriteFootballTeam;
    }

    public void setFavoriteFootballTeam(String favoriteFootballTeam) {
        this.favoriteFootballTeam = favoriteFootballTeam;
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
