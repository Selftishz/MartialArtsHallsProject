package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.Coach;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends MyBaseCrudRepository<Coach, Long> {
    @Modifying
    @Query("update Coach c set c.first_name = ?1, c.last_name = ?2, c.address = ?3, " +
            "c.phone_number = ?4, c.education = ?5, c.additional_education = ?6 where c.id_coach = ?7")
    void updateById(String first_name, String last_name, String address,
                    String phone_number, String education, String additional_education, Long id_coach);
}
