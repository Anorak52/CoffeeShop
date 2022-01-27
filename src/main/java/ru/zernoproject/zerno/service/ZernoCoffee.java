package ru.zernoproject.zerno.service;

import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.Employee;
import ru.zernoproject.zerno.model.dto.VisitorRequest;

public interface ZernoCoffee {

    String makeOrder(VisitorRequest visitorRequest);

    Object findInBonusSystem(BonusRequest bonusRequest);

    String addNewClientInBonusSystem(BonusRequest bonusRequest);

    String addEmployee(Employee newEmployee);
}
