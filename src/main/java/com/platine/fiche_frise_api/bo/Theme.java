package com.platine.fiche_frise_api.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theme {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String color;

    @OneToMany
    private List<Fiche> listFiches;

    @OneToMany
    private List<Frise> listFrises;

    public Theme(){

    }

    public Theme(int id, String name, String color, List<Fiche> listFiches, List<Frise> listFrises) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.listFiches = listFiches;
        this.listFrises = listFrises;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Fiche> getListFiches() {
        return listFiches;
    }

    public void setListFiches(List<Fiche> listFiches) {
        this.listFiches = listFiches;
    }

    public List<Frise> getListFrises() {
        return listFrises;
    }

    public void setListFrises(List<Frise> listFrises) {
        this.listFrises = listFrises;
    }
}
