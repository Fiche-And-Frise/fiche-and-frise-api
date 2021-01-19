package com.platine.fiche_frise_api.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evenement {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int dateDebut;

    @Column
    private int dateFin;

    public Evenement(){

    }

    public Evenement(int id, String name, int dateDebut, int dateFin) {
        this.id = id;
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public int getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(int dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDateFin() {
        return dateFin;
    }

    public void setDateFin(int dateFin) {
        this.dateFin = dateFin;
    }
}
