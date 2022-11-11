package ru.zernoproject.zerno.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddMenuPositionRequest;
import ru.zernoproject.zerno.model.dto.requests.AddOrderItemsListRequest;
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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static ru.zernoproject.zerno.utils.Constants.*;

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
        Staff staff = staffRepository.findStaffByFullName(request.getStaffName());
        if (staff == null) {
            return new AppResponse(EMPTY_STAFF_FROM_DB);
        }
        Users user = usersRepository.findUsersByMsisdn(request.getUserMsisdn());
        if (user == null) {
            return new AppResponse(EMPTY_USER_FROM_DB);
        }

        List<String> requestMenuPositions = request.getOrderItemsList().stream()
                .map(AddOrderItemsListRequest::getPosition).collect(Collectors.toList());
        List<Menu> findExistingMenuPositions = menuRepository.findAllByTitles(requestMenuPositions);

        if (findExistingMenuPositions.size() < request.getOrderItemsList().size()) {
            List<String> wrongPositionsFromRequest = requestMenuPositions.stream()
                    .filter(requestOrderPosition ->
                            !findExistingMenuPositions.stream().map(Menu::getTitle).collect(Collectors.toList())
                                    .contains(requestOrderPosition))
                    .collect(Collectors.toList());
            return new AppResponse(WORNG_POSITION_IN_ORDER_LIST + wrongPositionsFromRequest);
        }

        List<CustomerOrder> orderList = findExistingMenuPositions.stream()
                .map(menuPosition -> new CustomerOrder(staff, user, menuPosition,
                request.getOrderItemsList().stream()
                        .filter(userOrder -> userOrder.getPosition() != null && !userOrder.getPosition().isEmpty())
                        .filter(userOrder -> userOrder.getPosition().contains(menuPosition.getTitle()))
                        .findFirst().orElseThrow(NoSuchElementException::new)
                        .getAmount(),
                LocalDateTime.now())).collect(Collectors.toList());

        if (orderList.isEmpty()) {
            return new AppResponse(EMPTY_ORDER_LIST);
        }

        usersRepository.updateBonusAmountByMsisdn(request.getUserMsisdn(), user.getBonuses() + orderList.size());
        orderRepository.saveAll(orderList);
        return new AppResponse(ORDERCREATED);
    }

}
