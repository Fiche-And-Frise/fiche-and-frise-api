package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Theme;
import org.springframework.stereotype.Service;

@Service
public interface ThemeService {

    Theme getTheme(int idTheme);
    Iterable<Theme> getAllThemes();

    Theme createTheme(Theme theme);
    Theme updateTheme(Theme theme);

    void removeTheme(int idTheme);
}
