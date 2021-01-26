package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.stereotype.Service;

@Service
public interface ThemeService {

    //Themes
    Theme getTheme(int idTheme);
    Iterable<Theme> getAllThemes();
    Iterable<Theme> getThemesByUser(User currentUser);

    //Fiches
    Iterable<Fiche> getAllFiches(int themeId);

    //Frises
    Iterable<Frise> getAllFrises(int themeId);
    Theme createTheme(Theme theme);
    Theme updateTheme(Theme theme);

    void removeTheme(int idTheme);
}
