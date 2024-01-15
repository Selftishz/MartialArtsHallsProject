package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.model.Entities;
import by.podvintsev.martialartshallsproject.service.RequestToDatabaseService;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {
    ArrayList<String> arrayList = new ArrayList<>();
    @GetMapping ("/home")
    public String home(Model model) {
        return "home.html";
    }
    @GetMapping("/home/select")
    public String selectTable(Model model, @RequestParam("selectTable") String selectTable) {
        model.addAttribute("gym", new Gym());
        return selectTable.toLowerCase() + ".html";
    }
    @PostMapping(value = "/home/select/gym", params = "button=insert")
    public String insertGymOperation(Model model, @ModelAttribute("gym") Gym gym) {
        RequestToDatabaseService.insertIntoGym(gym);
        model.addAttribute(new Gym());
        return "gym.html";
    }

    @PostMapping(value = "/home/select/gym", params = "button=update")
    public String updateGymOperation(Model model, @ModelAttribute("gym") Gym gym) {
        RequestToDatabaseService.updateGym(gym);
        model.addAttribute(new Gym());
        return "gym.html";
    }
    @ModelAttribute("entities")
    public Entities[] entities() {
        return Entities.values();
    }

}
