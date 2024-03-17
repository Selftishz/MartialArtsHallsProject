package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.repository.GymRepository;
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
public class GymService {
    private final GymRepository gymRepository;
    public static final Logger log = LoggerFactory.getLogger(CoachService.class);
    public void insertIntoGym(Gym gym) {
        gymRepository.save(gym);
    }
    public void updateGym(Gym gym) {
        gymRepository.updateById(gym.getAddress(), gym.getId_gym());
    }
    public void deleteGym(Gym gym) {
        gymRepository.deleteById(gym.getId_gym());
    }
    public void uploadGym(List<Gym> allGyms, Model model) {
        log.info("Get into gym uploading method");
        allGyms = gymRepository.findAll();
        model.addAttribute("allGyms", allGyms);;
    }
}
