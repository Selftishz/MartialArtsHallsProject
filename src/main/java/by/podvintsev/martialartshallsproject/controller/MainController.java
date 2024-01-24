package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.model.Entities;
import by.podvintsev.martialartshallsproject.service.RequestToCoachDatabaseService;
import by.podvintsev.martialartshallsproject.service.RequestToGymDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    ArrayList<String> arrayList = new ArrayList<>();
    private List<Gym> allGyms = new ArrayList<>();
    private List<Coach> allCoaches = new ArrayList<>();
    @GetMapping ("/home")
    public String home(Model model) {
        return "home.html";
    }
    @GetMapping("/home/select")
    public String selectTable(Model model, @RequestParam("selectTable") String selectTable) {
        tableAnalysis(model, selectTable);
        return selectTable.toLowerCase() + ".html";
    }
    private void tableAnalysis(Model model, String selectTable) {
        switch (selectTable) {
            case "GYM" -> {
                model.addAttribute("gym", new Gym());
                RequestToGymDatabaseService.uploadGym(allGyms, model);
            }
            case "COACH" -> {
                model.addAttribute("coach", new Coach());
                RequestToCoachDatabaseService.uploadCoach(allCoaches, model);
            }
        }
    }
    @ModelAttribute("entities")
    public Entities[] getEntities() {
        return Entities.values();
    }

}
