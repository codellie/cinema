package cinema.domain;

import cinema.domain.*;
import cinema.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String movieName;
    private String movieId;
    private Integer qty;
    private Long customerId;
    private Integer amount;
    private String address;

    public Reserved(Reserve aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
