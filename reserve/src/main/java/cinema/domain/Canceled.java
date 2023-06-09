package cinema.domain;

import cinema.domain.*;
import cinema.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String movieName;
    private String movieId;
    private Integer qty;
    private Long customerId;
    private Integer amount;
    private String address;

    public Canceled(Reserve aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
