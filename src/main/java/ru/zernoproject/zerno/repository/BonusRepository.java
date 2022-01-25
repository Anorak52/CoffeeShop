package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.zernoproject.zerno.model.entity.Bonus;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Integer> {

    @Query("select t from Bonus t where t.phone = :phone")
    Bonus findByPhone(@Param(value = "phone") String phone);

    @Modifying
    @Query("update Bonus t set t.bonuses = :bonus where t.phone = :phone")
    void updateBonus(@Param(value = "phone") String phone,
                     @Param(value = "bonus") Integer bonus);
}
