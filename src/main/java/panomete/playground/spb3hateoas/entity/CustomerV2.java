package panomete.playground.spb3hateoas.entity;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerV2 extends RepresentationModel<CustomerV2> {
    private String id;
    private String name;
    private String company;
}
