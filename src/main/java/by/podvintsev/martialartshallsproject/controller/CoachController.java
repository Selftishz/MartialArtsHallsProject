package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.service.RequestToCoachDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoachController {
    private List<Coach> allCoaches = new ArrayList<>();

    @PostMapping(value = "/home/select/coach", params = "button=insert")
    public String insertCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        RequestToCoachDatabaseService.insertIntoCoach(coach);
        RequestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=update")
    public String updateCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        RequestToCoachDatabaseService.updateCoach(coach);
        RequestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=delete")
    public String deleteCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        RequestToCoachDatabaseService.deleteCoach(coach);
        RequestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
}
