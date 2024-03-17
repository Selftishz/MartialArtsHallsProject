package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.*;
import by.podvintsev.martialartshallsproject.repository.*;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupOfHallService {
    private final GroupOfHallRepository groupOfHallRepository;
    private final CoachRepository coachRepository;
    private final GymRepository gymRepository;
    private final TrainingRoomRepository trainingRoomRepository;
    private final SectionOfMartialArtRepository sectionOfMartialArtRepository;
    public static final Logger log = LoggerFactory.getLogger(GroupOfHallService.class);
    public void insertIntoGroupOfHall(Long id_coach, Long id_training_room, Long id_section,
                                      Long id_gym, Integer min_acceptable_age, Integer max_acceptable_age,
                                      Integer count_of_members) {
        groupOfHallRepository.save(GroupOfHall.builder()
                .id_coach(coachRepository.getReferenceById(id_coach))
                .count_of_members(count_of_members)
                .id_gym(gymRepository.getReferenceById(id_gym))
                .id_training_room(trainingRoomRepository.getReferenceById(id_training_room))
                .id_section(sectionOfMartialArtRepository.getReferenceById(id_section))
                .max_acceptable_age(max_acceptable_age)
                .min_acceptable_age(min_acceptable_age)
                .build());
    }
    public void updateGroupOfHall(Long id_group, Long id_coach, Long id_training_room, Long id_section,
                                         Long id_gym, Integer min_acceptable_age, Integer max_acceptable_age,
                                         Integer count_of_members) {
        Coach coach = coachRepository.getReferenceById(id_coach);
        TrainingRoom trainingRoom = trainingRoomRepository.getReferenceById(id_training_room);
        SectionOfMartialArt sectionOfMartialArt = sectionOfMartialArtRepository.getReferenceById(id_section);
        Gym gym = gymRepository.getReferenceById(id_gym);
        groupOfHallRepository.updateById(id_group, coach, trainingRoom,
                sectionOfMartialArt, gym, min_acceptable_age, max_acceptable_age, count_of_members);
    }
    public void deleteGroupOfHall(Long id_group) {
        groupOfHallRepository.deleteById(id_group);
    }
    public void uploadGroupOfHall(List<GroupOfHall> allGroups, Model model) {
        log.info("Get into GroupOfHall uploading method");
        allGroups = groupOfHallRepository.findAll();
        model.addAttribute("allGroups", allGroups);;
    }
}
