package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.entity.People;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RequestToCoachDatabaseService {
    public static final Logger log = LoggerFactory.getLogger(RequestToCoachDatabaseService.class);
    public static void insertIntoCoach(Coach coach) {
        log.info("In insertIntoCoach method: ");
        log.info("Human has been added: ");
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(coach);
            session.getTransaction().commit();
        }
        log.info("End of insertIntoCoach method: ");
    }
    public static void updateCoach(Coach coach) {
        /*try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Coach edit = session.get(Coach.class, coach.getId_coach());
            String address = coach.getHuman().getAddress();
            edit.getHuman().setAddress(address);
            session.getTransaction().commit();
        }*/
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
        log.info("Get into coach uploading method");
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var query = session.createSelectionQuery("SELECT c FROM Coach c ORDER BY c.id_coach ASC", Coach.class);
            allCoaches = query.getResultList();
            System.out.println(allCoaches);
        }
        model.addAttribute("allCoaches", allCoaches);
    }
}
