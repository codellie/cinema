package cinema.domain;

import cinema.TicketApplication;
import cinema.domain.Ticketcanceled;
import cinema.domain.Ticketsent;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Ticket_table")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String adress;

    private Long customerId;

    private String status;

    private String movieId;

    @PostPersist
    public void onPostPersist() {
        Ticketsent ticketsent = new Ticketsent(this);
        ticketsent.publishAfterCommit();

        Ticketcanceled ticketcanceled = new Ticketcanceled(this);
        ticketcanceled.publishAfterCommit();
    }

    public static TicketRepository repository() {
        TicketRepository ticketRepository = TicketApplication.applicationContext.getBean(
            TicketRepository.class
        );
        return ticketRepository;
    }

    public static void addTicket(Reserved reserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Ticket ticket = new Ticket();
        repository().save(ticket);

        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(ticket->{
            
            ticket // do something
            repository().save(ticket);


         });
        */

    }

    public static void cancelTicket(Canceled canceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Ticket ticket = new Ticket();
        repository().save(ticket);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(ticket->{
            
            ticket // do something
            repository().save(ticket);


         });
        */

    }
}
