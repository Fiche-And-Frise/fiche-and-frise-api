package com.platine.fiche_frise_api.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fiche {

    @Id
    private int id;

    @Column
    private String name;
    @Column
    private String recto;
    @Column
    private String verso;
    @Column
    private String theme;

    public Fiche(int id, String name, String recto, String verso, String theme) {
        this.id = id;
        this.name = name;
        this.recto = recto;
        this.verso = verso;
        this.theme = theme;
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

    public String getRecto() {
        return recto;
    }

    public void setRecto(String recto) {
        this.recto = recto;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
