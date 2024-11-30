package com.modulith.ddd.order;

import com.modulith.ddd.customer.Customer;
import com.modulith.ddd.order.Order.OrderId;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Table("test_order")
public class Order implements AggregateRoot<Order, OrderId> {

    private final OrderId id;
    private final Association<Customer, Customer.CustomerId> customer;

    public Order(OrderId id, UUID customer) {
        this.id = id;
        this.customer = Association.forId(new Customer.CustomerId(customer));
    }

    public static Order of(Customer customer) {
        return new Order(new OrderId(UUID.randomUUID()), customer.getId().id());
    }


    public record OrderId(UUID id) implements Identifier {
    }
}
