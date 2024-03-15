package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.*;
import by.podvintsev.martialartshallsproject.model.Entities;
import by.podvintsev.martialartshallsproject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final RequestToCoachDatabaseService requestToCoachDatabaseService;

    ArrayList<String> arrayList = new ArrayList<>();
    private List<Gym> allGyms = new ArrayList<>();
    private List<Coach> allCoaches = new ArrayList<>();
    private List<SectionOfMartialArt> allSections = new ArrayList<>();
    private List<TrainingRoom> allRooms = new ArrayList<>();
    private List<GroupOfHall> allGroups = new ArrayList<>();
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
                requestToCoachDatabaseService.uploadCoach(allCoaches, model);
            }
            case "SECTIONOFMARTIALART" -> {
                model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
                RequestToSectionOfMartialArtDatabaseService.uploadSection(allSections, model);
            }
            case "TRAININGROOM" -> {
                model.addAttribute("trainingroom", new TrainingRoom());
                RequestToTrainingRoomDatabaseService.uploadTrainingRoom(allRooms, model);
            }
            case "GROUPOFHALL" -> {
                model.addAttribute("groupofhall", new GroupOfHall());
                RequestToGroupOfHallDatabaseService.uploadGroupOfHall(allGroups, model);
            }
        }
    }
    @ModelAttribute("entities")
    public Entities[] getEntities() {
        return Entities.values();
    }

}
