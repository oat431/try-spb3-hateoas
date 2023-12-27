package panomete.playground.spb3hateoas.service;


import org.springframework.stereotype.Service;
import panomete.playground.spb3hateoas.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomerDetails(String id) {
        return new Customer(id, "John Doe", "Acme Inc.");
    }
}
