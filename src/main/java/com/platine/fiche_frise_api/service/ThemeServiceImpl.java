package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.repository.ThemeRepository;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService{

    private ThemeRepository repository;

    public ThemeServiceImpl(ThemeRepository repository){
        this.repository = repository;
    }

    @Override
    public Theme getTheme(int idTheme) {
        return this.repository.findById(idTheme).orElse(null);
    }

    @Override
    public Iterable<Theme> getAllThemes() {
        return this.repository.findAll();
    }

    @Override
    public Theme createTheme(Theme theme) {
        return this.repository.save(theme);
    }

    @Override
    public Theme updateTheme(Theme theme) {
        return this.repository.save(theme);
    }

    @Override
    public void removeTheme(int idTheme) {
        this.repository.delete(this.repository.findById(idTheme).get());
    }
}
