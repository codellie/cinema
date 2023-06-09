package cinema.domain;

import cinema.ReserveApplication;
import cinema.domain.Canceled;
import cinema.domain.Reserved;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reserve_table")
@Data
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieName;

    private String movieId;

    private Integer qty;

    private Long customerId;

    private Integer amount;

    private String address;

    @PostPersist
    public void onPostPersist() {
        // Get request from Reserve
        //cinema.external.Reserve reserve =
        //    Application.applicationContext.getBean(cinema.external.ReserveService.class)
        //    .getReserve(/** mapping value needed */);

    }

    @PrePersist
    public void onPrePersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }
}
