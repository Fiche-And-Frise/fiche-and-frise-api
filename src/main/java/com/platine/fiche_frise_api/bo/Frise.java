package com.platine.fiche_frise_api.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Frise {
    @Id
    private int id;

    @Column
    private String name;
    @Column
    private String theme;
    @Column
    private int dateDebut;
    @Column
    private int dateFin;
    @Column
    private String evenement;

    public Frise(){

    }

    public Frise(int id, String name, String theme, int dateDebut, int dateFin, String evenement){
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.evenement = evenement;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }
}
