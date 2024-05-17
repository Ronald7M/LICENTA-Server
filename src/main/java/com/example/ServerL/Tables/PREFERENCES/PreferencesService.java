package com.example.ServerL.Tables.PREFERENCES;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferencesService {
    private final PreferencesRepository repository;

    public PreferencesService(PreferencesRepository repository) {
        this.repository = repository;
    }
    public List<Preferences> getPreferences(){
        return repository.findAll();
    }
    public void insertPreferences(Preferences pref){
        repository.save(pref);
    }
    public void deletePreferences(Preferences pref){
        List<Preferences> all =repository.findAll();
        for (Preferences preferences : all) {
            if(preferences.getIdResource()==pref.getIdResource() && preferences.getIdUser()==pref.getIdUser()){
                repository.deleteById(preferences.getID());
                return;
            }
        }
        throw new IllegalStateException(String.format("Preferences doesn't exist "));


    }

}
