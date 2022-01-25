package ru.zernoproject.zerno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.Employee;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.model.entity.Bonus;
import ru.zernoproject.zerno.service.impl.ZernoCoffeeImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/zerno")
public class ZernoController {

    private final ZernoCoffeeImpl zernoCoffeeImpl;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody VisitorRequest visitorRequest) {
        return ResponseEntity.ok(zernoCoffeeImpl.makeOrder(visitorRequest));
    }

    @PostMapping("/addBonus")
    public ResponseEntity<String> addBonus(@RequestBody BonusRequest bonusRequest) {
        return ResponseEntity.ok(zernoCoffeeImpl.addBonus(bonusRequest));
    }

    @GetMapping("/getBonus")
    public ResponseEntity<Bonus> findBonus(@RequestBody BonusRequest bonusRequest) {
        return ResponseEntity.ok(zernoCoffeeImpl.findBonus(bonusRequest));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee newEmployee) {
        return ResponseEntity.ok(zernoCoffeeImpl.addEmployee(newEmployee));
    }
}
