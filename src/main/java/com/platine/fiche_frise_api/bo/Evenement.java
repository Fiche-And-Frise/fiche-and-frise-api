package com.platine.fiche_frise_api.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String dateDebut;

    @JsonBackReference(value = "frise_evenement")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "frise_id", nullable = false)
    private Frise frise;

    public Evenement(){

    }

    public Evenement(String name, String dateDebut, Frise frise) {
        this.name = name;
        this.dateDebut = dateDebut;
        this.frise = frise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Frise getFrise() {
        return frise;
    }

    public void setFrise(Frise frise) {
        this.frise = frise;
    }
}
