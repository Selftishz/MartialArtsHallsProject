package by.podvintsev.martialartshallsproject.unit.repositoryTest;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.repository.CoachRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CoachRepositoryTest {
    @Autowired
    private CoachRepository coachRepository;
    @Test
    public void CoachRepository_SaveCoaches_ReturnNotNullId() {
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
    public void CoachRepository_FindAllCoaches_ReturnMoreThanOne() {
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

    @Test
    public void CoachRepository_FindByIdCoach_ReturnCoach() {
        Coach coach1 = Coach.builder()
                .first_name("Vasiliy")
                .last_name("Petrov")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Mayakovskaya 28")
                .phone_number("+72823772612")
                .build();

        coachRepository.save(coach1);

        Optional<Coach> coach = coachRepository.findById(coach1.getId_coach());
        assertTrue(coach.isPresent());
    }

    @Test
    public void CoachRepository_UpdateByIdCoach_FieldsEqualsToNew() {
        Coach coach1 = Coach.builder()
                .first_name("Vasiliy")
                .last_name("Petrov")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Mayakovskaya 28")
                .phone_number("+72823772612")
                .build();

        Coach coach2 = Coach.builder()
                .id_coach(coach1.getId_coach())
                .first_name("Oleg")
                .last_name("Slutsky")
                .additional_education("St.Petersburg Sport University")
                .education("St.Petersburg Lathe University")
                .address("Netherland 12")
                .phone_number("+72827772612")
                .build();

        coachRepository.save(coach1);
        Coach findedCoach = coachRepository.findById(coach1.getId_coach()).get();
        findedCoach.setEducation(coach2.getEducation());
        findedCoach.setFirst_name(coach2.getFirst_name());
        findedCoach.setLast_name(coach2.getLast_name());
        findedCoach.setPhone_number(coach2.getPhone_number());
        findedCoach.setAdditional_education(coach2.getAdditional_education());
        findedCoach.setAddress(coach2.getAddress());
        Coach updatedCoach = coachRepository.save(findedCoach);
        Assertions.assertThat(updatedCoach.getAddress()).isEqualTo(coach2.getAddress());
        Assertions.assertThat(updatedCoach.getEducation()).isEqualTo(coach2.getEducation());
    }
}
