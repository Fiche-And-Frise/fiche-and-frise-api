package com.platine.fiche_frise_api.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Embeddable
public class Evenement {

    @Column
    private String name;

    @Column
    private String dateDebut;

    @Column
    private int ficheId;

    @Column
    private int themeId;

    public Evenement(){

    }

    public Evenement(String name, String dateDebut) {
        this.name = name;
        this.dateDebut = dateDebut;
        this.ficheId = -1;
        this.themeId = -1;
    }

    public Evenement(String name, String dateDebut, int ficheId, int themeId) {
        this.name = name;
        this.dateDebut = dateDebut;
        this.ficheId = ficheId;
        this.themeId = themeId;
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

    public int getFicheId() {
        return ficheId;
    }

    public void setFicheId(int ficheId) {
        this.ficheId = ficheId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
}
