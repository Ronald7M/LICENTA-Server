package com.example.ServerL.Tables.APPOINTMENT;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Appointment")
public class Appointment{

    @Id
    @SequenceGenerator(name="user_sequence",allocationSize = 1)
    @GeneratedValue(generator="user_sequence",strategy = GenerationType.SEQUENCE)
    private int idAppointment;
    private int idUser;
    private int idService;
    private LocalDateTime dateTime;

    public Appointment(int idAppointment, int idUser, int idService, LocalDateTime dateTime) {
        this.idAppointment = idAppointment;
        this.idUser = idUser;
        this.idService = idService;
        this.dateTime = dateTime;
    }
    public Appointment(){

    }
    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedTimeAndDate = dateTime.format(formatter);
        return formattedTimeAndDate;
    }
    public String getTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTimeAndDate = dateTime.format(formatter);
        return formattedTimeAndDate;
    }
}
