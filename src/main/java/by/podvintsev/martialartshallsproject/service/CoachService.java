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
        coachRepository.updateById(coach.getFirst_name(), coach.getFirst_name(),
                coach.getPhone_number(), coach.getAddress(), coach.getEducation(), coach.getAdditional_education(), coach.getId_coach());
    }
    public void deleteCoach(Coach coach) {
        coachRepository.delete(coach);
    }
    public void uploadCoach(List<Coach> allCoaches, Model model) {
        log.info("Get into coach uploading method");
        allCoaches = coachRepository.findAll();
        model.addAttribute("allCoaches", allCoaches);
    }
}
