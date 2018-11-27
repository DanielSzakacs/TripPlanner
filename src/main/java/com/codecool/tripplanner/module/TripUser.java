package com.codecool.tripplanner.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@NamedQuery(name = "singUpUser", query = "insert into TripUser (name, password) values (email = :email, password = :password)")
public class TripUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private List<Timeslot> timeslotList = new ArrayList<>();

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public TripUser(List<Timeslot> timeslotList, String name, String password) {
        this.timeslotList = timeslotList;
        this.username = name;
        this.password = password;
    }

    public TripUser(String name, String password) {
        this.username = name;
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

    @Override
    public String toString() {
        return "TripUser{" +
                "id=" + id +
                ", timeslotList=" + timeslotList +
                ", username='" + username + '\'' +
                '}';
    }
}
