package com.platine.fiche_frise_api.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Frise {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int dateDebut;

    @Column
    private int dateFin;

    @JsonManagedReference(value = "frise_evenement")
    @OneToMany(mappedBy = "frise", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Evenement> evenements;

    @JsonBackReference(value = "user_frise")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @JsonBackReference(value = "theme_frise")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    public Frise(){

    }

    public Frise(String name, int dateDebut, int dateFin, User user, Theme theme){
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
        return evenements;
    }

    public void setEvenements(List<Evenement> listEvenements) {
        this.evenements = listEvenements;
    }
    
    public Evenement getEvenementById(int idEvenement){
        for (Evenement e : evenements) {
            if(e.getId() == idEvenement){
                return e;
            }
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void addEvenement(Evenement newEvenement) {
        this.evenements.add(newEvenement);
    }
}
