package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RequestToCoachDatabaseService {
    public static void insertIntoCoach(Gym gym) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(gym);
            session.getTransaction().commit();
        }
    }
    public static void updateCoach(Gym gym) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Gym edit = session.get(Gym.class, gym.getId_gym());
            String address = gym.getAddress();
            edit.setAddress(address);
            session.getTransaction().commit();
        }
    }
    public static void deleteCoach(Coach coach) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var queryResult = session.createMutationQuery("delete from Coach where id_coach = :id").setParameter("id", coach.getId_coach());
            queryResult.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public static void uploadCoach(List<Coach> allCoaches, Model model) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var quary = session.createSelectionQuery("SELECT g FROM Coach g ORDER BY g.id_coach ASC", Coach.class);
            allCoaches = quary.getResultList();
            System.out.println(allCoaches);
        }
        model.addAttribute("allCoaches", allCoaches);
    }
}
