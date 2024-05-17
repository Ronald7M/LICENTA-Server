package com.example.ServerL.Tables.CATEGORY;

import jakarta.persistence.*;

@Entity
@Table(name="Category")
public class Category {

    @Id
    @SequenceGenerator(name="user_sequence",allocationSize = 1)
    @GeneratedValue(generator="user_sequence",strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String description;


    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Category(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return name;
    }
}
