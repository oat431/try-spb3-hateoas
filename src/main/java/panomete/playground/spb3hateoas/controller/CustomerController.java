package panomete.playground.spb3hateoas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panomete.playground.spb3hateoas.dto.CustomResponseBody;
import panomete.playground.spb3hateoas.entity.Customer;
import panomete.playground.spb3hateoas.entity.CustomerV2;
import panomete.playground.spb3hateoas.service.CustomerService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/v1/{id}")
    public ResponseEntity<CustomResponseBody<Customer>> getCustomerDetails(
            @PathVariable(name = "id") String id
    ) {
        CustomResponseBody<Customer> responseBody = new CustomResponseBody<>(
                customerService.getCustomerDetails(id)
        );
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<CustomResponseBody<CustomerV2>> getCustomerDetailsV2(
            @PathVariable(name = "id") String id
    ) {
        Link link = linkTo(methodOn(CustomerController.class).getCustomerOrders(id)).withSelfRel();
        CustomerV2 customerV2 = customerService.getCustomerDetailsV2(id);
        customerV2.add(link);
        CustomResponseBody<CustomerV2> responseBody = new CustomResponseBody<>(
                customerV2
        );
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/v2")
    public ResponseEntity<CustomResponseBody<CollectionModel<CustomerV2>>> getAllCustomerV2Details() {
        List<CustomerV2> customerV2List = customerService.getAllCustomerV2Details();
        customerV2List.forEach(customerV2 -> {
            Link link1 = linkTo(methodOn(CustomerController.class).getCustomerOrders(customerV2.getId())).withSelfRel();
            Link link2 = linkTo(methodOn(CustomerController.class).getCustomerDetailsV2(customerV2.getId())).withRel("customer");
            customerV2.add(link1, link2);
        });
        CollectionModel<CustomerV2> customerV2CollectionModel = CollectionModel.of(customerV2List);
        List<Link> links = List.of(
                linkTo(methodOn(CustomerController.class).ping()).withRel("ping")
        );
        customerV2CollectionModel.add(links);
        CustomResponseBody<CollectionModel<CustomerV2>> responseBody = new CustomResponseBody<>(
                customerV2CollectionModel
        );
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/v2/{id}/orders")
    public ResponseEntity<CustomResponseBody<List<String>>> getCustomerOrders(
            @PathVariable(name = "id") String id
    ) {
        CustomResponseBody<List<String>> responseBody = new CustomResponseBody<>(
                customerService.getCustomerOrders(id)
        );
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/v2/ping")
    public ResponseEntity<CustomResponseBody<String>> ping() {
        CustomResponseBody<String> responseBody = new CustomResponseBody<>(
                "pong"
        );
        return ResponseEntity.ok(responseBody);
    }
}
