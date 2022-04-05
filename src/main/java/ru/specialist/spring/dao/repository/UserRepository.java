package ru.specialist.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.specialist.spring.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
