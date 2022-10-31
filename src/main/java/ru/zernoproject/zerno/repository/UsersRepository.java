package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zernoproject.zerno.model.entity.Users;

import javax.transaction.Transactional;

@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findUsersByMsisdn(Long msisdn);

    @Modifying
    @Query("update Users t set t.bonuses = :bonuses where t.msisdn = :msisdn")
    void updateBonusAmountByMsisdn(@Param("msisdn") Long msisdn,@Param("bonuses") int bonuses);
}
