package com.example.ServerL.Tables.APPOINTMENT;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    public final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAppointments(){
        return repository.findAll();
    }
    public void postAppointment(Appointment ap){
        repository.save(ap);
    }
}
