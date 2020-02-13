package ru.linarkou.loans.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.linarkou.loans.v2.model.Application;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
    List<Application> findAllByPerson_FirstName(String firstName);

    /**
     * По сравнению с методом выше здесь будет жадная загрузка всех связанных Person
     */
    @Query("SELECT a FROM Application a JOIN FETCH a.person")
    List<Application> findAllByPersonFirstName_WithQuery(String firstName);

    List<Application> findAllByAmountGreaterThan(Long minAmount);
}
