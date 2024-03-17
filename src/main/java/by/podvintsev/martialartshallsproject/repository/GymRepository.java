package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.Gym;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GymRepository extends MyBaseCrudRepository<Gym, Long>{
    @Modifying
    @Query("update Gym c set c.address = ?1 where c.id_gym = ?2")
    void updateById(String address, Long id_gym);
}
