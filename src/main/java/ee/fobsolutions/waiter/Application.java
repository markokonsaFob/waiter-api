package ee.fobsolutions.waiter;

import ee.fobsolutions.waiter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by FOB Solutions
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        // reset
        menuService.reset();
        customerService.reset();
        orderService.reset();
        authenticationService.reset();

        // Add default content
        authenticationService.addAdminUser();
        menuService.addDefaultMenu();
    }
}
