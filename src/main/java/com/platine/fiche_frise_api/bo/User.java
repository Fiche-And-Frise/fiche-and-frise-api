package com.platine.fiche_frise_api.bo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String role;
    @OneToMany
    private List<Theme> themes;

    @OneToMany
    private List<Fiche> fiches;

    @OneToMany
    private List<Frise> frises;

    public User(String userName, String password, boolean active, String role, List<Theme> themes, List<Fiche> fiches, List<Frise> frises) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.role = role;
        this.themes = themes;
        this.fiches = fiches;
        this.frises = frises;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    public List<Frise> getFrises() {
        return frises;
    }

    public void setFrises(List<Frise> frises) {
        this.frises = frises;
    }
}
