package com.platine.fiche_frise_api.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String color;

    @JsonBackReference(value = "user_theme")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference(value = "theme_fiche")
    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Fiche> listFiches;
    @JsonManagedReference(value = "theme_frise")
    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Frise> listFrises;

    public Theme(){

    }

    public Theme(String name, String color, User user) {
        this.name = name;
        this.color = color;
        this.user = user;
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
