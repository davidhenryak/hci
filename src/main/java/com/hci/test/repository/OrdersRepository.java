package com.hci.test.repository;

import com.hci.test.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
  List<Orders> findAllByGroups_IdOrderByOrders(Long id);
}
