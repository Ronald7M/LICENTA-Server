package com.example.ServerL.Tables.APPOINTMENT;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/appointment")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Appointment> getAppointments(){
        return service.getAppointments();
    }
    @PostMapping
    public void postAppointment(@RequestBody Appointment ap){
        service.postAppointment(ap);
    }
}
