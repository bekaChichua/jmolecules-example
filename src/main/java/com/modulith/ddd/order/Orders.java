package com.modulith.ddd.order;

import org.jmolecules.ddd.annotation.Repository;
import org.jmolecules.ddd.integration.AssociationResolver;
import org.springframework.data.repository.CrudRepository;
import com.modulith.ddd.order.Order.OrderId;

@Repository
public interface Orders extends CrudRepository<Order, OrderId>, AssociationResolver<Order, OrderId> {
}
