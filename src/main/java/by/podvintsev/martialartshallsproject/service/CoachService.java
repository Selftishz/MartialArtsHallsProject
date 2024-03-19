package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;
    public static final Logger log = LoggerFactory.getLogger(CoachService.class);

    public void insertIntoCoach(Coach coach) {
        log.info("In insertIntoCoach method: ");
        log.info("Human has been added: ");
        coachRepository.save(coach);
        log.info("End of insertIntoCoach method: ");
    }
    public void updateCoach(Coach coach) {
        log.info("Get into Coach UPDATE method");
        /*coachRepository.updateById(coach.getFirst_name(), coach.getLast_name(), coach.getAddress(),
                coach.getPhone_number(), coach.getEducation(), coach.getAdditional_education(), coach.getId_coach());*/
        Coach coachInTable = coachRepository.findById(coach.getId_coach()).get();
        coachInTable.setPhone_number(coach.getPhone_number());
        coachInTable.setFirst_name(coach.getFirst_name());
        coachInTable.setLast_name(coach.getLast_name());
        coachInTable.setAdditional_education(coach.getAdditional_education());
        coachInTable.setEducation(coach.getEducation());
        coachInTable.setAddress(coach.getAddress());
        coachRepository.save(coachInTable);
    }
    public void deleteCoach(Coach coach) {
        coachRepository.deleteById(coach.getId_coach());
    }
    public void uploadCoach(List<Coach> allCoaches, Model model) {
        log.info("Get into coach uploading method");
        allCoaches = coachRepository.findAll();
        model.addAttribute("allCoaches", allCoaches);
    }
}
