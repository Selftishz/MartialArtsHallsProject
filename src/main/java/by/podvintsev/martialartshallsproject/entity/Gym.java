package by.podvintsev.martialartshallsproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "gym", schema = "public")
public class Gym {
    @Id
    private Integer id_gym;
    private String address;
}
