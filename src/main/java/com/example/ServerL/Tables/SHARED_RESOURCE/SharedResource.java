package com.example.ServerL.Tables.SHARED_RESOURCE;

import jakarta.persistence.*;

@Entity
@Table(name="SharedResource")
public class SharedResource {

    @Id
    @SequenceGenerator(name="resource_sequence",allocationSize = 1)
    @GeneratedValue(generator="resource_sequence",strategy = GenerationType.SEQUENCE)
    private int idResource;
    private int idUser;
    private int idCategory;
    private String description;
    private String name;
    private String scheduleS;

    public SharedResource(int idResource , int idUser, String description, String name, String scheduleS, int idCategory){
        this.idResource=idResource;
        this.idUser=idUser;
        this.idCategory=idCategory;
        this.description=description;
        this.name=name;
        this.scheduleS= scheduleS;
    }

    public SharedResource( int idUser,String name){
        this.idResource=-1;
        this.idUser=idUser;
        this.idCategory=0;
        this.description="without description";
        this.name=name;
        this.scheduleS="mon/08:00/19:00>tue/08:00/19:00>wed/08:00/19:00>thu/08:00/19:00>fri/08:00/19:00>sat/08:00/19:00>sun/08:00/19:00>";
    }
    public SharedResource(){

    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduleS() {
        return scheduleS;
    }

    public void setScheduleS(String schedule) {
        this.scheduleS = schedule;
    }
}
