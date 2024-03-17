package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.GroupOfHall;
import by.podvintsev.martialartshallsproject.service.GroupOfHallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupOfHallController {
    private final List<GroupOfHall> allGroups = new ArrayList<>();
    private final GroupOfHallService groupOfHallService;
    @PostMapping(value = "/home/select/groupofhall", params = "button=insert")
    public String insertGroupOperation(Model model, @RequestParam("id_coach") Integer id_coach,
                                       @RequestParam("id_training_room") Integer id_training_room,
                                       @RequestParam("id_section") Integer id_section,
                                       @RequestParam("id_gym") Integer id_gym,
                                       @RequestParam("min_acceptable_age") Integer min_acceptable_age,
                                       @RequestParam("max_acceptable_age") Integer max_acceptable_age,
                                       @RequestParam("count_of_members") Integer count_of_members) {
        groupOfHallService.insertIntoGroupOfHall(id_coach, id_training_room,
                id_section, id_gym, min_acceptable_age, max_acceptable_age, count_of_members);
        groupOfHallService.uploadGroupOfHall(allGroups, model);
        model.addAttribute("groupofhall", new GroupOfHall());
        return "groupofhall.html";
    }
    @PostMapping(value = "/home/select/groupofhall", params = "button=update")
    public String updateGroupOperation(Model model, @RequestParam("id_group_update") Integer id_group,
                                       @RequestParam("id_coach_update") Integer id_coach,
                                       @RequestParam("id_training_room_update") Integer id_training_room,
                                       @RequestParam("id_section_update") Integer id_section,
                                       @RequestParam("id_gym_update") Integer id_gym,
                                       @RequestParam("min_acceptable_age_update") Integer min_acceptable_age,
                                       @RequestParam("max_acceptable_age_update") Integer max_acceptable_age,
                                       @RequestParam("count_of_members_update") Integer count_of_members) {
        groupOfHallService.updateGroupOfHall(id_group, id_coach, id_training_room,
                id_section, id_gym, min_acceptable_age, max_acceptable_age, count_of_members);
        groupOfHallService.uploadGroupOfHall(allGroups, model);
        return "groupofhall.html";
    }
    @PostMapping(value = "/home/select/groupofhall", params = "button=delete")
    public String deleteGroupOperation(Model model, @RequestParam("id_group_delete") Integer id_group) {
        groupOfHallService.deleteGroupOfHall(id_group);
        groupOfHallService.uploadGroupOfHall(allGroups, model);
        model.addAttribute("groupofhall", new GroupOfHall());
        return "groupofhall.html";
    }
}
