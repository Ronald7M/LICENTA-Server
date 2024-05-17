package com.example.ServerL.Tables.PREFERENCES;


import jakarta.persistence.*;

@Entity
@Table(name="Preferences")
public class Preferences {
    @Id
    @SequenceGenerator(name="user_sequence",allocationSize = 1)
    @GeneratedValue(generator="user_sequence",strategy = GenerationType.SEQUENCE)
    private int ID;
    private int idUser;
    private int idResource;

    public Preferences(int idUser, int idObject) {
        this.idUser = idUser;
        this.idResource = idObject;
    }
    public Preferences(){

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
