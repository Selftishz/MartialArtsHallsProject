package by.podvintsev.martialartshallsproject.unit.repositoryTest;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.repository.CoachRepository;
import by.podvintsev.martialartshallsproject.repository.GymRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GymRepositoryTest {
    @Autowired
    private GymRepository gymRepository;
    @Test
    public void GymRepository_SaveGyms_ReturnNotNullId() {
        Gym gym1 = Gym.builder()
                .address("Nekrasovskaya 13")
                .build();

        Gym savedGym = gymRepository.save(gym1);

        Assertions.assertThat(savedGym).isNotNull();
        Assertions.assertThat(savedGym.getId_gym()).isGreaterThan(0);
    }

    @Test
    public void GymRepository_FindAllGyms_ReturnMoreThanOne() {
        Gym gym1 = Gym.builder()
                .address("Nekrasovskaya 13")
                .build();

        Gym gym2 = Gym.builder()
                .address("Letnaya 32")
                .build();

        gymRepository.save(gym1);
        gymRepository.save(gym2);

        List<Gym> list = gymRepository.findAll();
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void GymRepository_FindByIdGym_ReturnCoach() {
        Gym gym1 = Gym.builder()
                .address("Nekrasovskaya 13")
                .build();

        gymRepository.save(gym1);

        Optional<Gym> gym = gymRepository.findById(gym1.getId_gym());
        assertTrue(gym.isPresent());
    }

    @Test
    public void GymRepository_UpdateByIdGym_FieldsEqualsToNew() {
        Gym gym1 = Gym.builder()
                .address("Nekrasovskaya 13")
                .build();

        Gym gym2 = Gym.builder()
                .address("Letnaya 32")
                .build();

        gymRepository.save(gym1);
        Gym findedGym = gymRepository.findById(gym1.getId_gym()).get();
        findedGym.setAddress(gym2.getAddress());
        Gym updatedGym = gymRepository.save(findedGym);
        Assertions.assertThat(updatedGym.getAddress()).isEqualTo(gym2.getAddress());
    }
}
