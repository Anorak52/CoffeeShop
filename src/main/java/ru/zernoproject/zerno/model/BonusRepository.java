package ru.zernoproject.zerno.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.zernoproject.zerno.model.entity.BonusEntity;

import java.util.List;

public interface BonusRepository extends JpaRepository<BonusEntity, Integer> {
    List<BonusEntity> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select t from BonusEntity t where t.phone = :phone")
    BonusEntity findByPhone(@Param(value = "phone") String phone);

    @Transactional
    @Modifying
    @Query("update BonusEntity t set t.bonus = :bonus where t.phone = :phone")
    void updateBonus(@Param(value = "phone") String phone,
                     @Param(value = "bonus") Integer bonus);
}
