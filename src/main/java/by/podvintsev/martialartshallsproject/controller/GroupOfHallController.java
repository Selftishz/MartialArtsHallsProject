package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.GroupOfHall;
import by.podvintsev.martialartshallsproject.service.RequestToGroupOfHallDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupOfHallController {
    private final List<GroupOfHall> allGroups = new ArrayList<>();

    @PostMapping(value = "/home/select/groupofhall", params = "button=insert")
    public String insertGroupOperation(Model model, @ModelAttribute("groupofhall") GroupOfHall groupofhall) {
        RequestToGroupOfHallDatabaseService.insertIntoGroupOfHall(groupofhall);
        RequestToGroupOfHallDatabaseService.uploadGroupOfHall(allGroups, model);
        model.addAttribute("groupofhall", new GroupOfHall());
        return "groupofhall.html";
    }
    @PostMapping(value = "/home/select/groupofhall", params = "button=update")
    public String updateGroupOperation(Model model, @ModelAttribute("groupofhall") GroupOfHall groupofhall) {
        RequestToGroupOfHallDatabaseService.updateGroupOfHall(groupofhall);
        RequestToGroupOfHallDatabaseService.uploadGroupOfHall(allGroups, model);
        model.addAttribute("groupofhall", new GroupOfHall());
        return "groupofhall.html";
    }
    @PostMapping(value = "/home/select/groupofhall", params = "button=delete")
    public String deleteGroupOperation(Model model, @ModelAttribute("groupofhall") GroupOfHall groupofhall) {
        RequestToGroupOfHallDatabaseService.deleteGroupOfHall(groupofhall);
        RequestToGroupOfHallDatabaseService.uploadGroupOfHall(allGroups, model);
        model.addAttribute("groupofhall", new GroupOfHall());
        return "groupofhall.html";
    }
}
