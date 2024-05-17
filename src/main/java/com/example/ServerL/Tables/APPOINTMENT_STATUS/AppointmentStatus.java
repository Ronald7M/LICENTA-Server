package com.example.ServerL.Tables.APPOINTMENT_STATUS;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="AppointmentStatus")
public class AppointmentStatus {

    @Id
    @SequenceGenerator(name="resource_sequence",allocationSize = 1)
    @GeneratedValue(generator="resource_sequence",strategy = GenerationType.SEQUENCE)
    private int idAppointment;
    private int idStatus;
    private LocalDateTime dateTime;

    public AppointmentStatus(int idAppointment, int idStatus, LocalDateTime dateTime) {
        this.idAppointment = idAppointment;
        this.idStatus = idStatus;
        this.dateTime = dateTime;
    }
    public AppointmentStatus(){

    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


}
