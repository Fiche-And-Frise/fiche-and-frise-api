package com.platine.fiche_frise_api.bo;

import javax.persistence.*;

@Entity
public class Frise {
    @Id
    private int id;

    @Column
    private String name;
    @Column
    private int dateDebut;
    @Column
    private int dateFin;
    @Column
    private String evenement;

    @OneToOne
    private Theme idTheme;

    public Frise(){

    }

    public Frise(int id, String name, Theme idTheme, int dateDebut, int dateFin, String evenement){
        this.id = id;
        this.name = name;
        this.idTheme = idTheme;
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

    public Theme getTheme() {
        return idTheme;
    }

    public void setTheme(Theme theme) {
        this.idTheme = idTheme;
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
