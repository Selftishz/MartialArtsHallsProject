package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.service.CoachService;
import lombok.RequiredArgsConstructor;
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
    private final CoachService coachService;
    @PostMapping(value = "/home/select/coach", params = "button=insert")
    public String insertCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        coachService.insertIntoCoach(coach);
        coachService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=update")
    public String updateCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        coachService.updateCoach(coach);
        coachService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
    @PostMapping(value = "/home/select/coach", params = "button=delete")
    public String deleteCoachOperation(Model model, @ModelAttribute("coach") Coach coach) {
        coachService.deleteCoach(coach);
        coachService.uploadCoach(allCoaches, model);
        model.addAttribute("coach", new Coach());
        return "coach.html";
    }
}
