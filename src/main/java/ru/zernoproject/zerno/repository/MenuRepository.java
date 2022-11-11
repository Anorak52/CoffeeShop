package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zernoproject.zerno.model.entity.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    @Query("SELECT m FROM Menu m WHERE m.title IN :titles")
    List<Menu> findAllByTitles(@Param("titles") List<String> titles);

}
