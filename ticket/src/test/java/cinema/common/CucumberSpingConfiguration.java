package cinema.common;

import cinema.TicketApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { TicketApplication.class })
public class CucumberSpingConfiguration {}
