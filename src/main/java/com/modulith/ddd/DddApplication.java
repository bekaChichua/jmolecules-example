package com.modulith.ddd;

import com.modulith.ddd.customer.Customer;
import com.modulith.ddd.customer.Customers;
import com.modulith.ddd.order.Order;
import com.modulith.ddd.order.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DddApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OrderService orderService, Customers customers) {
        return args -> {
            var customer = new Customer("beka");
            var savedCustomer = customers.save(customer);
            System.out.println(savedCustomer);
            var order = Order.of(savedCustomer);
            var savedOrder = orderService.save(order);
            var foundOrder = orderService.findById(savedOrder.getId());
            System.out.println(foundOrder);

        };
    }
}
