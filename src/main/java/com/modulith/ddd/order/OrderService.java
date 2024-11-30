package com.modulith.ddd.order;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final Orders orders;

    public Order save (Order order) {
        return orders.save(order);
    }

    public Order findById(Order.OrderId id) {
        return orders.findById(id).orElseThrow();
    }
}
