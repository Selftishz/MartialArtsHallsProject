package by.podvintsev.martialartshallsproject.unit.repositoryTest;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CoachRepositoryTest {
    @Autowired
    private CoachRepository coachRepository;

    @Test
    public void CoachRepository_SaveCoachesCorrectly() {
        Coach coach1 = Coach.builder()
                .first_name("Vasiliy")
                .last_name("Petrovich")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Mayakovskaya 28")
                .phone_number("+72823772612")
                .build();

        Coach savedCoach = coachRepository.save(coach1);

        Assertions.assertThat(savedCoach).isNotNull();
        Assertions.assertThat(savedCoach.getId_coach()).isGreaterThan(0);
    }

    @Test
    public void CoachRepository_FindAll_ReturnMoreThanOne() {
        Coach coach1 = Coach.builder()
                .first_name("Vasiliy")
                .last_name("Petrov")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Mayakovskaya 28")
                .phone_number("+72823772612")
                .build();

        Coach coach2 = Coach.builder()
                .first_name("Oleg")
                .last_name("Slutsky")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Netherland 12")
                .phone_number("+72827772612")
                .build();

        coachRepository.save(coach1);
        coachRepository.save(coach2);

        List<Coach> list = coachRepository.findAll();
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
