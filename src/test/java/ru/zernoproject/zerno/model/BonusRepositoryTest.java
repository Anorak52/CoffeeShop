package ru.zernoproject.zerno.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.model.entity.Phone;
import ru.zernoproject.zerno.repository.BonusRepository;
import ru.zernoproject.zerno.repository.PhoneRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("Test")
class BonusRepositoryTest {

    @Autowired
    private BonusRepository bonusRepository;


    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    void anotherTest() {
        Phone phone = new Phone("1111111111");
        phoneRepository.save(phone);
        Bonus bonusEntity = new Bonus(1, "Marc", "Stevinson", 10, phone);
        Bonus savedBonusEntity = bonusRepository.save(bonusEntity);
        assertThat(savedBonusEntity).usingRecursiveComparison().isEqualTo(bonusEntity);
    }

    @Test
    void setterTest() {
        Phone phone = new Phone("1111111111");
        Bonus bonusEntity = new Bonus(3, "Marc", "Stevinson", 10, phone);
        bonusEntity.setBonuses(0);
        Assert.assertEquals(0, bonusEntity.getBonuses());
    }
}