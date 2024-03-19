package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.TrainingRoom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TrainingRoomRepository extends MyBaseCrudRepository<TrainingRoom, Long> {

}
