package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zernoproject.zerno.model.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
