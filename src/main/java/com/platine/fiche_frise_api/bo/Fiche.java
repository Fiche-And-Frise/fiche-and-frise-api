package com.platine.fiche_frise_api.bo;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    public Fiche(){

    }

    public Fiche(int id, String name, String recto, String verso, User user, Theme theme) {
        this.id = id;
        this.name = name;
        this.recto = recto;
        this.verso = verso;
        this.user = user;
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


}
