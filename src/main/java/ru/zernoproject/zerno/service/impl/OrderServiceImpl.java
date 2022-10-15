package ru.zernoproject.zerno.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddMenuPositionRequest;
import ru.zernoproject.zerno.model.dto.requests.AddOrderRequest;
import ru.zernoproject.zerno.model.entity.CustomerOrder;
import ru.zernoproject.zerno.model.entity.Menu;
import ru.zernoproject.zerno.model.entity.Staff;
import ru.zernoproject.zerno.model.entity.Users;
import ru.zernoproject.zerno.repository.MenuRepository;
import ru.zernoproject.zerno.repository.OrderRepository;
import ru.zernoproject.zerno.repository.StaffRepository;
import ru.zernoproject.zerno.repository.UsersRepository;
import ru.zernoproject.zerno.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.zernoproject.zerno.enums.Constants.CREATED;
import static ru.zernoproject.zerno.enums.Constants.ORDERCREATED;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final StaffRepository staffRepository;
    private final UsersRepository usersRepository;

    @Override
    public AppResponse addMenuPosition(AddMenuPositionRequest request) {
        menuRepository.save(new Menu(request.getPosition(), request.getPrice()));
        return new AppResponse(CREATED);
    }

    @Override
    public AppResponse addOrder(AddOrderRequest request) {
        List<CustomerOrder> orderList = new ArrayList<>();
        Staff staff = staffRepository.findStaffByFullName(request.getStaffName());
        Users user = usersRepository.findUsersByMsisdn(request.getUserMsisdn());
        log.info("Get Menu pos {}", request.getMenuPostions().size());
        request.getMenuPostions().forEach(x->{
            Menu menu = menuRepository.findMenuByTitle(x);
            orderList.add(new CustomerOrder(staff, user, menu, LocalDateTime.now()));
        });
        orderRepository.saveAll(orderList);
        int responseBonuses = user.getBonuses();
        return new AppResponse(ORDERCREATED + ", number of bonuses is " + responseBonuses);
    }

}
