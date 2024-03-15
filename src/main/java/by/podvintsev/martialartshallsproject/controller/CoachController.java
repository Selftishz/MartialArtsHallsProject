package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.service.RequestToCoachDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CoachController {
    private List<Coach> allCoaches = new ArrayList<>();
    private final RequestToCoachDatabaseService requestToCoachDatabaseService;
    @PostMapping(value = "/home/select/coach", params = "button=insert")
    public String insertCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        requestToCoachDatabaseService.insertIntoCoach(coach);
        requestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=update")
    public String updateCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        requestToCoachDatabaseService.updateCoach(coach);
        requestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=delete")
    public String deleteCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        requestToCoachDatabaseService.deleteCoach(coach);
        requestToCoachDatabaseService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
}
