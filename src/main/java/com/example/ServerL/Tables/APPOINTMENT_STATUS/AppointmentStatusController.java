package com.example.ServerL.Tables.APPOINTMENT_STATUS;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/appointmentStatus")
public class AppointmentStatusController {

    public final AppointmentStatusService service;

    public AppointmentStatusController(AppointmentStatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppointmentStatus> getAppointmentStatus(){
        return service.getAppointmentStatus();
    }
    @PostMapping
    public void postAppointmentStatus(@RequestBody AppointmentStatus as){
        service.postAppointmentStatus(as);
    }


}
