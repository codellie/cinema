package cinema.external;

import java.util.Date;
import lombok.Data;

@Data
public class Reserve {

    private Long id;
    private String movieName;
    private String movieId;
    private Integer qty;
    private Long customerId;
    private Integer amount;
    private String address;
}
