package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ActorRepo extends JpaRepository<Actor, Long> {

    Actor getActorByName(String name);
}
