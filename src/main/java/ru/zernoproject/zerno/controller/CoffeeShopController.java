package ru.zernoproject.zerno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zernoproject.zerno.model.dto.AddBonusRequest;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.service.CoffeeShopService;

@RestController
@RequestMapping("v1/zerno")
@RequiredArgsConstructor
public class CoffeeShopController {

    private final CoffeeShopService coffeeShopService;

    @PostMapping(value = "add_bonus",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse> addBonus(@RequestBody AddBonusRequest dto) {
        return ResponseEntity.ok(coffeeShopService.addBonus(dto));
    }
}
