package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.service.RequestToGymDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GymController {
    private List<Gym> allGyms = new ArrayList<>();

    @PostMapping(value = "/home/select/gym", params = "button=insert")
    public String insertGymOperation(Model model, @ModelAttribute("gym") Gym gym) {
        RequestToGymDatabaseService.insertIntoGym(gym);
        RequestToGymDatabaseService.uploadGym(allGyms, model);
        model.addAttribute("gym", new Gym());
        return "gym.html";
    }
    @PostMapping(value = "/home/select/gym", params = "button=update")
    public String updateGymOperation(Model model, @ModelAttribute("gym") Gym gym) {
        RequestToGymDatabaseService.updateGym(gym);
        RequestToGymDatabaseService.uploadGym(allGyms, model);
        model.addAttribute("gym", new Gym());
        return "gym.html";
    }
    @PostMapping(value = "/home/select/gym", params = "button=delete")
    public String deleteGymOperation(Model model, @ModelAttribute("gym") Gym gym) {
        RequestToGymDatabaseService.deleteGym(gym);
        RequestToGymDatabaseService.uploadGym(allGyms, model);
        model.addAttribute("gym", new Gym());
        return "gym.html";
    }
}
