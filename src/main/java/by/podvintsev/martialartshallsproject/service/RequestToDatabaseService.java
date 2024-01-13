package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;

@Service
public class RequestToDatabaseService {

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
            edit.setAddress(gym.getAddress());
            session.getTransaction().commit();
        }
    }
}
