package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.TrainingRoom;
import by.podvintsev.martialartshallsproject.service.TrainingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TrainingRoomController {
    private TrainingRoomService trainingRoomService;
    private List<TrainingRoom> allRooms = new ArrayList<>();

    @PostMapping(value = "/home/select/trainingroom", params = "button=insert")
    public String insertGymOperation(Model model, @ModelAttribute("trainingroom") TrainingRoom trainingroom) {
        trainingRoomService.insertIntoTrainingRoom(trainingroom);
        trainingRoomService.uploadTrainingRoom(allRooms, model);
        model.addAttribute("trainingroom", new TrainingRoom());
        return "trainingroom.html";
    }
    @PostMapping(value = "/home/select/trainingroom", params = "button=update")
    public String updateGymOperation(Model model, @ModelAttribute("trainingroom") TrainingRoom trainingroom) {
        trainingRoomService.updateTrainingRoom(trainingroom);
        trainingRoomService.uploadTrainingRoom(allRooms, model);
        model.addAttribute("trainingroom", new TrainingRoom());
        return "trainingroom.html";
    }
    @PostMapping(value = "/home/select/trainingroom", params = "button=delete")
    public String deleteGymOperation(Model model, @ModelAttribute("trainingroom") TrainingRoom trainingroom) {
        trainingRoomService.deleteTrainingRoom(trainingroom);
        trainingRoomService.uploadTrainingRoom(allRooms, model);
        model.addAttribute("trainingroom", new TrainingRoom());
        return "trainingroom.html";
    }
}
