package ru.zernoproject.zerno.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.zernoproject.zerno.repository.BonusRepository;
import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.VisitorOrder;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.model.entity.Bonus;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("Test")
class ZernoCoffeeImplTest {

    @Autowired
    private ZernoCoffeeImpl zernoCoffeeImpl;

    @Autowired
    private BonusRepository bonusRepository;

    @BeforeEach
    void setUp() {
        Bonus bonusEntity = new Bonus(1, "John", "Markovich", 10, "89375621853");
        Bonus savedBonusEntity = bonusRepository.save(bonusEntity);
    }

    @Test
    void zernoCoffeeMakeOrderTest() {
        List<VisitorOrder> visitorOrder = List.of(new VisitorOrder("Flet", 3));
        VisitorRequest visitorRequest = new VisitorRequest("John", "Markovich", "89375621853", visitorOrder, true);
        String response = zernoCoffeeImpl.makeOrder(visitorRequest);
        Assert.assertEquals("John", visitorRequest.getFirstName());
        Assert.assertEquals("Markovich", visitorRequest.getLastName());
        Assert.assertTrue(visitorRequest.isDiscount());
        Assert.assertEquals("Flet", visitorOrder.get(0).getOrderName());
        Assert.assertEquals("Спасибо за ваш заказ, вам начисленно 3 баллов. Ваше общее количество баллов - 13 ", response);
    }

    @Test
    void findBonusTest() {
        BonusRequest bonusRequest = new BonusRequest("Test", "Test", "89375621853");
        Bonus bonus = zernoCoffeeImpl.findBonus(bonusRequest);
        Assert.assertEquals(bonus.getPhone(), bonusRequest.getPhone());
        Assert.assertEquals(10, bonus.getBonuses());
    }

    @Test
    void addBonusTest() {
        BonusRequest bonusRequest = new BonusRequest("Test", "Test", "1");
        String returnString = zernoCoffeeImpl.addBonus(bonusRequest);
        Assert.assertEquals("Пользователь добавлен в бонусную программу", returnString);
    }

    @Test
    void addBonusAlreadyInUseTest() {
        BonusRequest bonusRequest = new BonusRequest("Test", "Test", "89375621853");
        String returnString = zernoCoffeeImpl.addBonus(bonusRequest);
        Assert.assertEquals("Пользователь уже есть в бонусной программе", returnString);
    }

}