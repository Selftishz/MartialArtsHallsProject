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
@Table(name = "coach", schema = "public")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_coach;
    private String first_name;
    private String last_name;
    private String address;
    private String phone_number;
    private String education;
    private String additional_education;
}
