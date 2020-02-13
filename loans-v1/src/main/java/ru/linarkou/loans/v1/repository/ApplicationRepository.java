package ru.linarkou.loans.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.linarkou.loans.v1.model.Application;

@Repository // @Component, предназначенный для хранения, извлечения и поиска. (работа с БД)
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
