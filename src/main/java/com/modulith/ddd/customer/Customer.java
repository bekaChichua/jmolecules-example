package com.modulith.ddd.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import com.modulith.ddd.customer.Customer.CustomerId;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Customer implements AggregateRoot<Customer, CustomerId> {

    private final CustomerId id;
    private final String name;

    public Customer(String name) {
        this.id = new CustomerId(UUID.randomUUID());
        this.name = name;
    }


    public record CustomerId(UUID id) implements Identifier {}
}
