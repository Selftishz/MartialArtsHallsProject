package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.entity.TrainingRoom;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RequestToTrainingRoomDatabaseService {
    public static void insertIntoTrainingRoom(TrainingRoom trainingRoom) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(trainingRoom);
            session.getTransaction().commit();
        }
    }
    public static void updateTrainingRoom(TrainingRoom trainingRoom) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            TrainingRoom edit = session.get(TrainingRoom.class, trainingRoom.getId_training_room());
            Integer room_number = trainingRoom.getRoom_number();
            edit.setRoom_number(room_number);
            session.getTransaction().commit();
        }
    }
    public static void deleteTrainingRoom(TrainingRoom trainingRoom) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var queryResult = session
                    .createMutationQuery("delete from TrainingRoom where id_training_room = :id")
                    .setParameter("id", trainingRoom.getId_training_room());
            queryResult.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public static void uploadTrainingRoom(List<TrainingRoom> allRooms, Model model) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var query = session
                    .createSelectionQuery("SELECT g FROM TrainingRoom g ORDER BY g.id_training_room ASC", TrainingRoom.class);
            allRooms = query.getResultList();
            System.out.println(allRooms);
        }
        model.addAttribute("allRooms", allRooms);
    }
}
