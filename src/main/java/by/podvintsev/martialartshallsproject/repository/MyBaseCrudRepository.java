package by.podvintsev.martialartshallsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyBaseCrudRepository<T, ID> extends JpaRepository<T, ID> {
    void updateById();
}
