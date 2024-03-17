package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOfHallRepository extends MyBaseCrudRepository<GroupOfHall, Long> {
    @Modifying
    @Query("update GroupOfHall c set c.id_coach = ?2, c.id_training_room = ?3," +
            "c.id_section = ?4, c.id_gym = ?5,  c.min_acceptable_age = ?6," +
            "c.max_acceptable_age = ?7, c.count_of_members = ?8 where c.id_group = ?1")
    void updateById(Long id_group, Coach coach, TrainingRoom trainingRoom, SectionOfMartialArt section,
                    Gym gym, Integer min_acceptable_age, Integer max_acceptable_age,
                    Integer count_of_members);
}
