package ru.zernoproject.zerno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zernoproject.zerno.model.entity.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, String> {
}
