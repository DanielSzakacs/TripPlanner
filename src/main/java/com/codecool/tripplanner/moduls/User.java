package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Timeslot> timeslotList = new ArrayList<>();
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;


    public User(List<Timeslot> timeslotList, String name, String password) {
        this.timeslotList = timeslotList;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public void addToTimeSlot(Timeslot timeslot){
        this.timeslotList.add(timeslot);
    }

    public void addTimeSlot(List<Timeslot> timeslotList){
        this.timeslotList = timeslotList;
    }
}
