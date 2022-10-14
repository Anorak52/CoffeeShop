package ru.zernoproject.zerno.service;

import ru.zernoproject.zerno.model.dto.AddBonusRequest;
import ru.zernoproject.zerno.model.dto.AppResponse;

public interface CoffeeShopService {
    AppResponse addBonus(AddBonusRequest dto);
}
