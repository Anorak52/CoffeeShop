package ru.zernoproject.zerno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.Employee;
import ru.zernoproject.zerno.model.dto.VisitorOrder;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.model.entity.Phone;
import ru.zernoproject.zerno.model.entity.Staff;
import ru.zernoproject.zerno.repository.BonusRepository;
import ru.zernoproject.zerno.repository.StaffRepository;
import ru.zernoproject.zerno.service.ZernoCoffee;

import java.util.List;

@Service
public class ZernoCoffeeImpl implements ZernoCoffee {

    private final BonusRepository bonusRepository;
    private final StaffRepository staffRepository;

    @Autowired
    private ZernoCoffeeImpl(BonusRepository bonusRepository, StaffRepository staffRepository){
        this.bonusRepository = bonusRepository;
        this.staffRepository = staffRepository;
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

    @Override
    public String addEmployee(Employee employee) {
        Staff newEmployee = new Staff(employee.getFirstName(), employee.getLastName(), employee.getAddress(),
                employee.getPosition(), employee.getSalary());
        newEmployee.setPhone(new Phone(employee.getPhone()));
        staffRepository.save(newEmployee);
        return "Новый сотрудник добавлен";
    }

}

