package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Coach;
import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestToGymDatabaseService {
    public static void insertIntoGym(Gym gym) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(gym);
            session.getTransaction().commit();
        }
    }
    public static void updateGym(Gym gym) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Gym edit = session.get(Gym.class, gym.getId_gym());
            String address = gym.getAddress();
            edit.setAddress(address);
            session.getTransaction().commit();
        }
    }
    public static void deleteGym(Gym gym) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var queryResult = session.createMutationQuery("delete from Gym where id_gym = :id").setParameter("id", gym.getId_gym());
            queryResult.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public static void uploadGym(List<Gym> allGyms, Model model) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var query = session.createSelectionQuery("SELECT g FROM Gym g ORDER BY g.id_gym ASC", Gym.class);
            allGyms = query.getResultList();
        }
        model.addAttribute("allGyms", allGyms);
    }
}
