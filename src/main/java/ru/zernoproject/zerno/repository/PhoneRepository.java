package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zernoproject.zerno.model.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("select t from Phone t where t.number = :number")
    Phone findByPhone(@Param(value = "number") String number);

}
