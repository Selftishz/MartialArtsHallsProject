package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import by.podvintsev.martialartshallsproject.repository.SectionOfMartialArtRepository;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SectionOfMartialArtService {
    public static final Logger log = LoggerFactory.getLogger(CoachService.class);
    private final SectionOfMartialArtRepository sectionOfMartialArtRepository;
    public void insertIntoSection(SectionOfMartialArt section) {
        sectionOfMartialArtRepository.save(section);
    }
    public void updateSection(SectionOfMartialArt section) {
        sectionOfMartialArtRepository.updateById(section.getSection_name(), section.getId_section());
    }
    public void deleteSection(SectionOfMartialArt section) {
        sectionOfMartialArtRepository.deleteById(section.getId_section());
    }
    public void uploadSection(List<SectionOfMartialArt> allSections, Model model) {
        log.info("Get into section uploading method");
        allSections = sectionOfMartialArtRepository.findAll();
        model.addAttribute("allSections", allSections);
    }
}
