package by.podvintsev.martialartshallsproject.repository;

import by.podvintsev.martialartshallsproject.entity.SectionOfMartialArt;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SectionOfMartialArtRepository extends MyBaseCrudRepository<SectionOfMartialArt, Long>{
    @Modifying
    @Query("update SectionOfMartialArt c set c.section_name = ?1 where c.id_section = ?2")
    void updateById(String section_name, Long id_section);
}
