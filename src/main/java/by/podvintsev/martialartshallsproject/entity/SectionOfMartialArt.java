package by.podvintsev.martialartshallsproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "section_of_martial_art", schema = "public")
public class SectionOfMartialArt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_section;
    String section_name;
}
