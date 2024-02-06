package by.podvintsev.martialartshallsproject.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group_of_hall", schema = "public")
public class GroupOfHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_group;
    @ManyToOne()
    @JoinColumn(name = "id_coach")
    private Coach id_coach;
    @ManyToOne
    @JoinColumn(name = "id_training_room")
    private TrainingRoom id_training_room;
    @ManyToOne
    @JoinColumn(name = "id_section")
    private SectionOfMartialArt id_section;
    @ManyToOne
    @JoinColumn(name = "id_gym")
    private Gym id_gym;
    private Integer min_acceptable_age;
    private Integer max_acceptable_age;
    private Integer count_of_members;
}
