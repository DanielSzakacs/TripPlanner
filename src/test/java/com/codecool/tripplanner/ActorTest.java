package com.codecool.tripplanner;

import com.codecool.tripplanner.module.Actor;
import com.codecool.tripplanner.repository.ActorRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ActorTest {

    @Autowired
    ActorRepo actorRepo;


    @Test
    public void getActorByName(){

        String name = "Bud Spencer";

        Actor budspencer = new Actor("Bud Spencer");

        Mockito.when(actorRepo.getActorByName(budspencer.getName())).thenReturn(budspencer);

        assertThat(actorRepo.getActorByName(name)).isEqualTo(actorRepo.getActorByName("Bud Spencer"));
    }
}
