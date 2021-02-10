package com.platine.fiche_frise_api.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Embeddable
public class Evenement {

    @Column
    private String name;

    @Column
    private String dateDebut;

    public Evenement(){

    }

    public Evenement(String name, String dateDebut) {
        this.name = name;
        this.dateDebut = dateDebut;
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
}
