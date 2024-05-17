package com.example.ServerL.Tables.APPOINTMENT_STATUS;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentStatusService {
    public final AppointmentStatusRepository repository;

    public AppointmentStatusService(AppointmentStatusRepository repository) {
        this.repository = repository;
    }
    public List<AppointmentStatus> getAppointmentStatus(){
        return repository.findAll();
    }
    public void postAppointmentStatus(AppointmentStatus as){
        repository.save(as);
        System.out.println(as.getDateTime().toString());
    }


}
