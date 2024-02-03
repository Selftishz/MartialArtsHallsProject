package by.podvintsev.martialartshallsproject;

import by.podvintsev.martialartshallsproject.entity.Gym;
import by.podvintsev.martialartshallsproject.model.Entities;
import by.podvintsev.martialartshallsproject.util.HibernateUtil;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MartialArtsHallsProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartialArtsHallsProjectApplication.class, args);
    }
}


