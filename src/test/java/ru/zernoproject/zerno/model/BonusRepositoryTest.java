package ru.zernoproject.zerno.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.repository.BonusRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("Test")
class BonusRepositoryTest {

    @Autowired
    private BonusRepository bonusRepository;

    @Test
    void anotherTest() {
        Bonus bonusEntity = new Bonus(1, "Marc", "Stevinson", 10, "89375621853");
        Bonus savedBonusEntity = bonusRepository.save(bonusEntity);
        assertThat(savedBonusEntity).usingRecursiveComparison().isEqualTo(bonusEntity);
    }

    @Test
    void anotherTestTwo() {
        Bonus bonusEntity = new Bonus(1, "Marc", "Stevinson", 10, "89375621853");
        bonusRepository.save(bonusEntity);
        Bonus byPhone = bonusRepository.findByPhone("89375621853");
        Assert.assertEquals(byPhone.getPhone(), bonusEntity.getPhone());
    }

    @Test
    void setterTest() {
        Bonus bonusEntity = new Bonus(1, "Marc", "Stevinson", 10, "89375621853");
        bonusEntity.setBonuses(0);
        Assert.assertEquals(0, bonusEntity.getBonuses());
    }
}