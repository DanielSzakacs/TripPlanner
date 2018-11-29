package com.codecool.tripplanner;

import com.codecool.tripplanner.module.TripUser;
import com.codecool.tripplanner.repository.TripUserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TripUserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TripUserRepo tripUserRepository;

    @Test
    public void whenFindByUsername_thenReturnTripUser() {
        //given
        TripUser timi = new TripUser("Timi", "password");
        entityManager.persist(timi);
        entityManager.flush();
//        entityManager.persistAndFlush(timi);

        //when
        TripUser found = tripUserRepository.findByUsername(timi.getUsername());

        //then
        assertThat(found.getUsername()).isEqualTo(timi.getUsername());
    }
}
