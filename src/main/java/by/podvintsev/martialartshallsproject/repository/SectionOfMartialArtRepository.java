package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SectionOfMartialArtRepository extends MyBaseCrudRepository<SectionOfMartialArt, Long>{

}
