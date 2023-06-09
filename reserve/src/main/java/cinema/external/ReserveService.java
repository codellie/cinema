package cinema.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "reserve", url = "${api.url.reserve}")
public interface ReserveService {
    @RequestMapping(method = RequestMethod.POST, path = "/reserves")
    public void createOrder(@RequestBody Reserve reserve);
}
