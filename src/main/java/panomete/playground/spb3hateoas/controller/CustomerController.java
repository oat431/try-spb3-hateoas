package panomete.playground.spb3hateoas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panomete.playground.spb3hateoas.entity.Customer;
import panomete.playground.spb3hateoas.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/v1/{id}")
    public ResponseEntity<Customer> getCustomerDetails(
            @PathVariable(name = "id") String id
    ) {
        return ResponseEntity.ok(customerService.getCustomerDetails(id));
    }
}
