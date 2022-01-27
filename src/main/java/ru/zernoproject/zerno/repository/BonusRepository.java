package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.model.entity.Phone;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Integer> {
    @Modifying
    @Query("update Bonus t set t.bonuses = :bonus where t.phoneId = :phoneId")
    @Transactional
    void updateBonus(@Param(value = "phoneId") Phone phoneId,
                     @Param(value = "bonus") Integer bonus);
}
