package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.*;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class RequestToGroupOfHallDatabaseService {
    public static void insertIntoGroupOfHall(Integer id_coach, Integer id_training_room, Integer id_section,
                                             Integer id_gym, Integer min_acceptable_age, Integer max_acceptable_age,
                                             Integer count_of_members) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            Coach coach = session.get(Coach.class, id_coach);
            TrainingRoom trainingRoom = session.get(TrainingRoom.class, id_training_room);
            SectionOfMartialArt sectionOfMartialArt = session.get(SectionOfMartialArt.class, id_section);
            Gym gym = session.get(Gym.class, id_gym);
            GroupOfHall groupOfHall = GroupOfHall.builder()
                    .id_training_room(trainingRoom)
                    .id_gym(gym)
                    .id_section(sectionOfMartialArt)
                    .id_coach(coach)
                    .count_of_members(count_of_members)
                    .max_acceptable_age(max_acceptable_age)
                    .min_acceptable_age(min_acceptable_age).build();
            session.beginTransaction();
            session.persist(groupOfHall);
            session.getTransaction().commit();
        }
    }
    public static void updateGroupOfHall(GroupOfHall groupofhall) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            GroupOfHall edit = session.get(GroupOfHall.class, groupofhall.getId_group());
            //Integer room_number =
            //edit.setRoom_number(room_number);
            session.getTransaction().commit();
        }
    }
    public static void deleteGroupOfHall(GroupOfHall groupofhall) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var queryResult = session
                    .createMutationQuery("delete from GroupOfHall where id_group = :id")
                    .setParameter("id", groupofhall.getId_group());
            queryResult.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public static void uploadGroupOfHall(List<GroupOfHall> allGroups, Model model) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var query = session
                    .createSelectionQuery("SELECT g FROM GroupOfHall g ORDER BY g.id_group ASC", GroupOfHall.class);
            allGroups = query.getResultList();
            System.out.println(allGroups);
        }
        model.addAttribute("allGroups", allGroups);
    }
}
