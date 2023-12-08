package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.model.Entities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {
    ArrayList<String> arrayList = new ArrayList<>();

    @GetMapping ("/home")
    public String home(Model model) {
        model.addAttribute("entities", Entities.values());
        model.addAttribute("answer", "NO INSERT!");

        return "home.html";
    }

    @PostMapping("/home/insert")
    public String insert(Model model) {
        model.addAttribute("answer", "INSERT added!");
        return "home.html";
    }
}
