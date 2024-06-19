package com.example.ServerL.Tables.APPOINTMENT_STATUS;

import com.example.ServerL.Tables.APPOINTMENT.Appointment;
import com.example.ServerL.Tables.APPOINTMENT.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentStatusService {
    public final AppointmentStatusRepository repository;
    public final AppointmentRepository apR ;

    public AppointmentStatusService(AppointmentStatusRepository repository, AppointmentRepository apR) {
        this.repository = repository;
        this.apR = apR;
    }
    public List<AppointmentStatus> getAppointmentStatus(){
        return repository.findAll();
    }
    public void postAppointmentStatus(AppointmentStatus as){

        as.setIdAppointment(getLastID());
        repository.save(as);
        System.out.println(as.getDateTime().toString());
    }
    public int getLastID(){
        List<Appointment> list=apR.findAll();
        int max=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getIdAppointment()>max){
                max=list.get(i).getIdAppointment();
            }
        }
        return max;
    }


}
