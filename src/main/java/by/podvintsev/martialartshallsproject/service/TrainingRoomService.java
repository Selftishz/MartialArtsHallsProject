package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.TrainingRoom;
import by.podvintsev.martialartshallsproject.repository.TrainingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainingRoomService {
    public static final Logger log = LoggerFactory.getLogger(TrainingRoomService.class);
    private final TrainingRoomRepository trainingRoomRepository;
    public void insertIntoTrainingRoom(TrainingRoom trainingRoom) {
        trainingRoomRepository.save(trainingRoom);
    }
    public void updateTrainingRoom(TrainingRoom trainingRoom) {
        TrainingRoom roomInTable = trainingRoomRepository.findById(trainingRoom.getId_training_room()).get();
        roomInTable.setRoom_number(trainingRoom.getRoom_number());
        trainingRoomRepository.save(roomInTable);
    }
    public void deleteTrainingRoom(TrainingRoom trainingRoom) {
        trainingRoomRepository.deleteById(trainingRoom.getId_training_room());
    }
    public void uploadTrainingRoom(List<TrainingRoom> allRooms, Model model) {
        log.info("Get into training room uploading method");
        allRooms = trainingRoomRepository.findAll();
        model.addAttribute("allRooms", allRooms);
    }
}
