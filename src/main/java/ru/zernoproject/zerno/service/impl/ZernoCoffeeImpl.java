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
import ru.zernoproject.zerno.repository.PhoneRepository;
import ru.zernoproject.zerno.repository.StaffRepository;
import ru.zernoproject.zerno.service.ZernoCoffee;

import java.util.List;

@Service
public class ZernoCoffeeImpl implements ZernoCoffee {

    private final BonusRepository bonusRepository;
    private final StaffRepository staffRepository;
    private final PhoneRepository phoneRepository;

    @Autowired
    private ZernoCoffeeImpl(BonusRepository bonusRepository, StaffRepository staffRepository,
                            PhoneRepository phoneRepository){
        this.bonusRepository = bonusRepository;
        this.staffRepository = staffRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public String makeOrder(VisitorRequest visitorRequest) {
        if (!visitorRequest.getPhone().isEmpty()) {
            Phone phone = phoneRepository.findByPhone(visitorRequest.getPhone());
            if (phone != null) {
                int bonus = 0;
                List<VisitorOrder> order = visitorRequest.getOrder();
                for (VisitorOrder visitorOrder : order) {
                    bonus += visitorOrder.getOrderNumber();
                }
                int bonusSum = phone.getBonusId().getBonuses() + bonus;
                bonusRepository.updateBonus(phone, bonusSum);
                return String.format("Спасибо за ваш заказ, вам начисленно %d баллов. Ваше общее количество баллов - %d ",
                        bonus, bonusSum);
            } else {
                return "Извините, клиент не зарегистрирован в программе";
            }
        } else return "Спасибо за заказ!";
    }

    @Override
    public Bonus findInBonusSystem(BonusRequest bonusRequest) {
            return phoneRepository.findByPhone(bonusRequest.getPhone()).getBonusId();
    }

    @Override
    public String addNewClientInBonusSystem(BonusRequest bonusRequest) {
        Phone checkPhone = phoneRepository.findByPhone(bonusRequest.getPhone());
        if (checkPhone == null) {
            Bonus bonus = new Bonus();
                bonus.setFirstName(bonusRequest.getFirstName());
                bonus.setLastName(bonusRequest.getLastName());
                Phone phone = new Phone(bonusRequest.getPhone());
                bonus.setPhoneId(phone);
                bonus.setBonuses(0);
                bonusRepository.save(bonus);
                return "Пользователь добавлен в бонусную программу";
        } else return "Пользователь уже есть в бонусной программе";
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

