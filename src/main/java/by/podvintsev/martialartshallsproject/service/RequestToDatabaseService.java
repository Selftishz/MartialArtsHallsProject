package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.hibernate.query.MutationQuery;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
            System.out.println(queryResult);
            session.getTransaction().commit();
        }
    }
}
