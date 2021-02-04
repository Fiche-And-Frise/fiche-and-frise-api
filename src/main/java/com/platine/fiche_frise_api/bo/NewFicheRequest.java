package com.platine.fiche_frise_api.bo;

public class NewFicheRequest {
    private Fiche fiche;
    private Theme theme;

    public NewFicheRequest(Fiche fiche, Theme theme) {
        this.fiche = fiche;
        this.theme = theme;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
