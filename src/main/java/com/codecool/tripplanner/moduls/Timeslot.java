package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "timeslot")
    private WalkingTour walkingtour;

    //@Temporal(TemporalType.TIME)
    private LocalDateTime dateTime;

    @Column(name = "maxPax")
    private int maxPax;

    @ManyToMany(mappedBy = "timeslotList")
    private List<TripUser> visitors = new ArrayList<>();

    public Timeslot(LocalDateTime now) {
    }

    public Timeslot(LocalDateTime dateTime, int maxPax) {
        this.dateTime = dateTime;
        this.maxPax = maxPax;
    }

    public Timeslot(WalkingTour walkingtour, LocalDateTime dateTime, int maxPax) {

        this.walkingtour = walkingtour;
        this.dateTime = dateTime;
        this.maxPax = maxPax;
    }


    public void addWalkingTour(WalkingTour walkingTour){
        this.walkingtour = walkingTour;
    }
}
