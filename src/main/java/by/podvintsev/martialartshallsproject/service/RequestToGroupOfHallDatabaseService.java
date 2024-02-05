package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.GroupOfHall;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RequestToGroupOfHallDatabaseService {
    public static void insertIntoGroupOfHall(GroupOfHall groupofhall) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(groupofhall);
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
