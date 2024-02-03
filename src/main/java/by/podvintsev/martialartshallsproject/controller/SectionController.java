package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import by.podvintsev.martialartshallsproject.service.RequestToGymDatabaseService;
import by.podvintsev.martialartshallsproject.service.RequestToSectionOfMartialArtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SectionController {
    private List<SectionOfMartialArt> allSections = new ArrayList<>();

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=insert")
    public String insertGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        RequestToSectionOfMartialArtService.insertIntoSection(sectionofmartialart);
        RequestToSectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=update")
    public String updateGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        RequestToSectionOfMartialArtService.updateSection(sectionofmartialart);
        RequestToSectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=delete")
    public String deleteGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        RequestToSectionOfMartialArtService.deleteSection(sectionofmartialart);
        RequestToSectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }
}
