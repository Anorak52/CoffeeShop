package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zernoproject.zerno.model.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
