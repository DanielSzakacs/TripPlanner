package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private WalkingTour tour;

    @Temporal(TemporalType.DATE)
    private Date dateTime;

    @Column(name = "maxPax")
    private int maxPax;

    @OneToMany
    private List<User> visitors = new ArrayList<>();

    public Timeslot() {
    }

    public Timeslot(Date dateTime, int maxPax) {
        this.dateTime = dateTime;
        this.maxPax = maxPax;
    }

    public Timeslot(WalkingTour tour, Date dateTime, int maxPax) {

        this.tour = tour;
        this.dateTime = dateTime;
        this.maxPax = maxPax;
    }


    public void addWalkingTour(WalkingTour walkingTour){
        this.tour = walkingTour;
    }
}
