package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.Gym;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GymRepository extends MyBaseCrudRepository<Gym, Long>{

}
