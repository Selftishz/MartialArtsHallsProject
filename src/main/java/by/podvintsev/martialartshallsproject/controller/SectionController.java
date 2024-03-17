package by.podvintsev.martialartshallsproject.controller;

import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import by.podvintsev.martialartshallsproject.repository.SectionOfMartialArtRepository;
import by.podvintsev.martialartshallsproject.service.SectionOfMartialArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SectionController {
    private final SectionOfMartialArtService sectionOfMartialArtService;
    private List<SectionOfMartialArt> allSections = new ArrayList<>();

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=insert")
    public String insertGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        sectionOfMartialArtService.insertIntoSection(sectionofmartialart);
        sectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=update")
    public String updateGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        sectionOfMartialArtService.updateSection(sectionofmartialart);
        sectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }

    @PostMapping(value = "/home/select/sectionofmartialart", params = "button=delete")
    public String deleteGymOperation(Model model, @ModelAttribute("sectionofmartialart")
    SectionOfMartialArt sectionofmartialart) {
        sectionOfMartialArtService.deleteSection(sectionofmartialart);
        sectionOfMartialArtService.uploadSection(allSections, model);
        model.addAttribute("sectionofmartialart", new SectionOfMartialArt());
        return "sectionofmartialart.html";
    }
}
