package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.TrainingRoom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TrainingRoomRepository extends MyBaseCrudRepository<TrainingRoom, Long> {
    @Modifying
    @Query("update TrainingRoom c set c.room_number = ?1 where c.id_training_room = ?2")
    void updateById(Integer room_number, Long id_training_room);
}
