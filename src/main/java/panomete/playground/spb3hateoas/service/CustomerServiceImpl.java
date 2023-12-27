package panomete.playground.spb3hateoas.service;


import org.springframework.stereotype.Service;
import panomete.playground.spb3hateoas.entity.Customer;
import panomete.playground.spb3hateoas.entity.CustomerV2;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomerDetails(String id) {
        return new Customer(id, "John Doe", "Acme Inc.");
    }

    @Override
    public CustomerV2 getCustomerDetailsV2(String id) {
        return CustomerV2.builder()
                .id(id)
                .name("John Doe")
                .company("Acme Inc.")
                .build();
    }

    @Override
    public List<CustomerV2> getAllCustomerV2Details() {
        return List.of(
                CustomerV2.builder()
                        .id("1")
                        .name("John Doe")
                        .company("Acme Inc.")
                        .build(),
                CustomerV2.builder()
                        .id("2")
                        .name("Jane Doe")
                        .company("Acme Inc.")
                        .build(),
                CustomerV2.builder()
                        .id("3")
                        .name("John Smith")
                        .company("Acme Inc.")
                        .build()
        );
    }

    @Override
    public List<String> getCustomerOrders(String id) {
        return List.of("order1", "order2", "order3");
    }
}
