package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zernoproject.zerno.model.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, String> {
}
