package cinema.domain;

import cinema.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tickets", path = "tickets")
public interface TicketRepository
    extends PagingAndSortingRepository<Ticket, Long> {}
