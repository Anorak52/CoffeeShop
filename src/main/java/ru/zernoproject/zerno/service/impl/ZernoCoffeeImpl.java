package ru.zernoproject.zerno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.BonusRepository;
import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.VisitorOrder;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.service.ZernoCoffee;

import java.util.List;

@Service
public class ZernoCoffeeImpl implements ZernoCoffee {

    private final BonusRepository bonusRepository;

    @Autowired
    private ZernoCoffeeImpl(BonusRepository bonusRepository){
        this.bonusRepository = bonusRepository;
    }

    @Override
    public String makeOrder(VisitorRequest visitorRequest) {
        Bonus visitor = bonusRepository.findByPhone(visitorRequest.getPhone());
        int bonus = 0;
        List<VisitorOrder> order = visitorRequest.getOrder();
        for (VisitorOrder visitorOrder : order) {
            bonus += visitorOrder.getOrderNumber();
        }
        int bonusSum = visitor.getBonuses()+bonus;
        bonusRepository.updateBonus(visitorRequest.getPhone(), bonusSum);
        return String.format("Спасибо за ваш заказ, вам начисленно %d баллов. Ваше общее количество баллов - %d ", bonus, bonusSum);
    }

    @Override
    public Bonus findBonus(BonusRequest bonusRequest) {
        return bonusRepository.findByPhone(bonusRequest.getPhone());
    }

    @Override
    public String addBonus(BonusRequest bonusRequest) {
        Bonus findUserAlready = findBonus(bonusRequest);
        if (findUserAlready==null) {
            Bonus bonus = new Bonus();
            bonus.setFirstName(bonusRequest.getFirstName());
            bonus.setLastName(bonusRequest.getLastName());
            bonus.setPhone(bonusRequest.getPhone());
            bonus.setBonuses(0);
            bonusRepository.save(bonus);
            return "Пользователь добавлен в бонусную программу";
        } else {
            return "Пользователь уже есть в бонусной программе";
        }
    }

}

