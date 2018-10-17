package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TripUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Timeslot> timeslotList = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public TripUser(List<Timeslot> timeslotList, String name, String password) {
        this.timeslotList = timeslotList;
        this.name = name;
        this.password = password;
    }

    public TripUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public TripUser() {
    }

    public void addToTimeSlot(Timeslot timeslot){
        this.timeslotList.add(timeslot);
    }

    public void addTimeSlot(List<Timeslot> timeslotList){
        this.timeslotList = timeslotList;
    }
}
