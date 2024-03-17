package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.GroupOfHall;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOfHallRepository extends MyBaseCrudRepository<GroupOfHall, Long> {
    @Modifying
    @Query("update GroupOfHall c set c.min_acceptable_age = ?1, " +
            "c.max_acceptable_age = ?2, c.count_of_members = ?3 where c.id_group = ?4")
    void updateById(Integer min_acceptable_age, Integer max_acceptable_age, Integer count_of_members, Long id_group);
}
