package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zernoproject.zerno.model.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {

    @Query("SELECT s FROM Staff s WHERE s.fullName = :name")
    Staff findStaffByFullName(@Param("name") String name);
}
