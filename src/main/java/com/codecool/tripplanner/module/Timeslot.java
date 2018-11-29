package com.codecool.tripplanner.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "getalltimeslot",query = "select t from Timeslot t")
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "timeslot")
    private WalkingTour walkingtour;

    public long getId() {
        return id;
    }

    public WalkingTour getWalkingtour() {
        return walkingtour;
    }

    public String  getDateTime() {
        return dateTime;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public List<TripUser> getVisitors() {
        return visitors;
    }

    //@Temporal(TemporalType.TIME)
    private String dateTime;

    @Column(name = "maxPax")
    private int maxPax;

    @ManyToMany(mappedBy = "timeslotList")
    private List<TripUser> visitors = new ArrayList<>();

    public Timeslot() {
    }

    public Timeslot(String dateTime, int maxPax) {
        this.dateTime = dateTime;
        this.maxPax = maxPax;
    }

    public Timeslot(WalkingTour walkingtour, String dateTime) {
        this.walkingtour = walkingtour;
        this.dateTime = dateTime;
    }


    public void addWalkingTour(WalkingTour walkingTour){
        this.walkingtour = walkingTour;
    }
}
