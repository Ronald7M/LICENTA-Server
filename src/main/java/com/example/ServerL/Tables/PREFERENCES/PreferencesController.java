package com.example.ServerL.Tables.PREFERENCES;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/preferences")
public class PreferencesController {
    private final PreferencesService service;

    public PreferencesController(PreferencesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Preferences> getPreferences(){
        return service.getPreferences();
    }
    @PostMapping
    public void insertPreference(@RequestBody Preferences pref){
        service.insertPreferences(pref);
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody Preferences pref){
        service.deletePreferences(pref);
    }




}
