package com.platine.fiche_frise_api.bo;

import javax.persistence.*;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int dateDebut;

    @Column
    private int dateFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "frise_id", nullable = false)
    private Frise frise;

    public Evenement(){

    }

    public Evenement(String name, int dateDebut, int dateFin, Frise frise) {
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
