package com.example.ServerL.Tables.APPOINTMENT;

import com.example.ServerL.Tables.APPOINTMENT_STATUS.AppointmentStatus;
import com.example.ServerL.Tables.APPOINTMENT_STATUS.AppointmentStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    public final AppointmentRepository repository;
    public final AppointmentStatusRepository repositoryStatus;



    public AppointmentService(AppointmentRepository repository, AppointmentStatusRepository repositoryStatus) {
        this.repository = repository;
        this.repositoryStatus = repositoryStatus;
    }

    public List<Appointment> getAppointments(){
        return repository.findAll();
    }
    public void postAppointment(Appointment ap){


        repository.save(ap);
        List<Appointment> list =getAppointments();
        repositoryStatus.save(new AppointmentStatus(getMax(list),1,ap.getDateTime()));



    }

    public int getMax(List<Appointment> x){
        int max=-1;
        for (int i = 0; i < x.size(); i++) {
            if(x.get(i).getIdAppointment()>max){
                max=x.get(i).getIdAppointment();
            }
        }
        return max;
    }

}
