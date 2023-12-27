package panomete.playground.spb3hateoas.service;

import panomete.playground.spb3hateoas.entity.Customer;
import panomete.playground.spb3hateoas.entity.CustomerV2;

import java.util.List;

public interface CustomerService {
    Customer getCustomerDetails(String id);
    CustomerV2 getCustomerDetailsV2(String id);
    List<CustomerV2> getAllCustomerV2Details();
    List<String> getCustomerOrders(String id);
}
