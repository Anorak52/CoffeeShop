package ru.zernoproject.zerno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddMenuPositionRequest;
import ru.zernoproject.zerno.model.dto.requests.AddOrderRequest;
import ru.zernoproject.zerno.service.OrderService;

@RestController
@RequestMapping("zerno/v1/order/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "add_order",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse> addOrder(@RequestBody AddOrderRequest dto) {
        return ResponseEntity.ok(orderService.addOrder(dto));
    }

    @PostMapping(value = "add_menu",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse> addMenuPosition(@RequestBody AddMenuPositionRequest dto) {
        return ResponseEntity.ok(orderService.addMenuPosition(dto));
    }
}
