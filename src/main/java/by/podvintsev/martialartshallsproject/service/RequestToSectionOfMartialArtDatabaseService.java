package by.podvintsev.martialartshallsproject.service;

import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RequestToSectionOfMartialArtDatabaseService {
    public static void insertIntoSection(SectionOfMartialArt section) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(section);
            session.getTransaction().commit();
        }
    }
    public static void updateSection(SectionOfMartialArt section) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            SectionOfMartialArt edit = session.get(SectionOfMartialArt.class, section.getId_section());
            String name = section.getSection_name();
            edit.setSection_name(name);
            session.getTransaction().commit();
        }
    }
    public static void deleteSection(SectionOfMartialArt section) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var queryResult = session
                    .createMutationQuery("delete from SectionOfMartialArt where id_section = :id")
                    .setParameter("id", section.getId_section());
            queryResult.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public static void uploadSection(List<SectionOfMartialArt> allSections, Model model) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()) {
            var query = session
                    .createSelectionQuery("SELECT a FROM SectionOfMartialArt a ORDER BY a.id_section ASC",
                            SectionOfMartialArt.class);
            allSections = query.getResultList();
        }
        model.addAttribute("allSections", allSections);
    }
}
