package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.zernoproject.zerno.model.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
