package ru.zernoproject.zerno.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.zernoproject.zerno.model.dto.VisitorOrder;
import ru.zernoproject.zerno.model.dto.VisitorRequest;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZernoCoffeeImplTest {

    @Autowired
    private ZernoCoffeeImpl zernoCoffeeImpl;

    @Test
    void zernoCoffee() {
        List<VisitorOrder> visitorOrder = List.of(new VisitorOrder("Flet", 3));
        VisitorRequest visitorRequest = new VisitorRequest("John", "Markovich","89738563685", visitorOrder, true);
        String response = zernoCoffeeImpl.makeOrder(visitorRequest);
        Assert.assertEquals("John", visitorRequest.getFirstName());
        Assert.assertEquals("Markovich", visitorRequest.getLastName());
        Assert.assertTrue(visitorRequest.isDiscount());
        Assert.assertEquals("Flet", visitorOrder.get(0).getOrderName());
        Assert.assertEquals("Спасибо за ваш заказ, вам начисленно 3 баллов", response);
    }
}