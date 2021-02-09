package com.platine.fiche_frise_api.bo;

public class NewEvenementRequest {
    private Frise frise;
    private Theme theme;
    private Evenement evenement;
    private int index;

    public NewEvenementRequest(Frise frise, Theme theme, Evenement evenement, int index) {
        this.frise = frise;
        this.theme = theme;
        this.evenement = evenement;
        this.index = index;
    }

    public Frise getFrise() {
        return frise;
    }

    public void setFrise(Frise frise) {
        this.frise = frise;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
