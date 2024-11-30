package com.modulith.ddd.customer;

import org.jmolecules.ddd.integration.AssociationResolver;
import org.springframework.data.repository.CrudRepository;
import com.modulith.ddd.customer.Customer.CustomerId;

public interface Customers extends CrudRepository<Customer, CustomerId>, AssociationResolver<Customer, CustomerId> {
}
