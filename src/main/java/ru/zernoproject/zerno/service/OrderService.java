package ru.zernoproject.zerno.service;

import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddMenuPositionRequest;
import ru.zernoproject.zerno.model.dto.requests.AddOrderRequest;

public interface OrderService {
    AppResponse addMenuPosition(AddMenuPositionRequest request);
    AppResponse addOrder(AddOrderRequest request);
}
