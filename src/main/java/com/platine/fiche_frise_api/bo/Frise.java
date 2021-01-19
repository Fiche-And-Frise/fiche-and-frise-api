package com.platine.fiche_frise_api.bo;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<Evenement> listEvenements;

    /*@OneToOne
    private Theme idTheme;*/

    public Frise(){

    }

    public Frise(int id, String name, int dateDebut, int dateFin, List<Evenement> listEvenements){
        this.id = id;
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.listEvenements = listEvenements;
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

    public List<Evenement> getEvenements() {
        return listEvenements;
    }

    public void setEvenements(List<Evenement> listEvenements) {
        this.listEvenements = listEvenements;
    }
    
    public Evenement getEvenementById(int idEvenement){
        for (Evenement e : listEvenements) {
            if(e.getId() == idEvenement){
                return e;
            }
        }
        return null;
    }
}
