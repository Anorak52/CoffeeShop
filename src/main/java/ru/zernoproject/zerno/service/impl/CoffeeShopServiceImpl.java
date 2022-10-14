package ru.zernoproject.zerno.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.dto.AddBonusRequest;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.entity.CustomerOrder;
import ru.zernoproject.zerno.model.entity.Menu;
import ru.zernoproject.zerno.model.entity.Users;
import ru.zernoproject.zerno.repository.UsersRepository;
import ru.zernoproject.zerno.repository.MenuRepository;
import ru.zernoproject.zerno.repository.OrderRepository;
import ru.zernoproject.zerno.service.CoffeeShopService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CoffeeShopServiceImpl implements CoffeeShopService {

    private final UsersRepository usersRepository;
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public AppResponse addBonus(AddBonusRequest request) {
        Users user = new Users("Mike Johnson", 9047957527L, 1);
        Menu menu = new Menu("Muffin", 100.0);
        Menu menuCup = new Menu("Capuccino", 100.0);
        usersRepository.save(user);
        menuRepository.saveAll(List.of(menuCup, menu));
        orderRepository.save(new CustomerOrder("Steve Jankovich", user, menu));
        orderRepository.save(new CustomerOrder("Steve Jankovich", user, menuCup));
//        log.info("Get {}", orderRepository.findAll().get(0).getMenu().getPrice());
        return new AppResponse("created");
    }

}
