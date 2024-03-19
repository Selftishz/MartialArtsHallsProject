package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOfHallRepository extends MyBaseCrudRepository<GroupOfHall, Long> {

}
