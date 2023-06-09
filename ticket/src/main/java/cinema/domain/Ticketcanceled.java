package cinema.domain;

import cinema.domain.*;
import cinema.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ticketcanceled extends AbstractEvent {

    private Long id;
    private String adress;
    private Long customerId;
    private String status;
    private String movieId;

    public Ticketcanceled(Ticket aggregate) {
        super(aggregate);
    }

    public Ticketcanceled() {
        super();
    }
}
