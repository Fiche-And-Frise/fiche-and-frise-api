package com.platine.fiche_frise_api.bo;

public class NewFriseRequest {
    private Frise frise;
    private Theme theme;

    public NewFriseRequest(Frise frise, Theme theme) {
        this.frise = frise;
        this.theme = theme;
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
}
