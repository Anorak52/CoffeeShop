package ru.zernoproject.zerno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zernoproject.zerno.model.dto.BonusRequest;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.model.entity.BonusEntity;
import ru.zernoproject.zerno.service.impl.ZernoCoffeeImpl;

import java.util.List;

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
    public ResponseEntity<BonusEntity> findBonus(@RequestBody BonusRequest bonusRequest) {
        return ResponseEntity.ok(zernoCoffeeImpl.findBonus(bonusRequest));
    }

//    @DeleteMapping("/orders")
//    public ResponseEntity<VisitorRequest> deleteOrder(@RequestBody VisitorRequest visitorRequest) {
//        return ResponseEntity.ok(zernoCoffeeImpl.zernoCoffee(visitorRequest));
//    }
//
//    @GetMapping("/orders")
//    public ResponseEntity<VisitorRequest> deleteOrder(@RequestBody VisitorRequest visitorRequest) {
//        return ResponseEntity.ok(zernoCoffeeImpl.zernoCoffee(visitorRequest));
//    }
}
