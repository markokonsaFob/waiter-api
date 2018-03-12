package ee.fobsolutions.waiter.service;

import ee.fobsolutions.waiter.dao.CustomerRepository;
import ee.fobsolutions.waiter.models.Customer;
import ee.fobsolutions.waiter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by FOB Solutions
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderService orderService;


    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer addCustomer(String name) {
        return repository.save(new Customer(name));
    }

    public Customer updateCustomer(String id, String name, String waiterId, boolean hasMenu) {
        Customer customer = repository.findById(id);
        User user = authenticationService.getUser(waiterId);
        if (user != null && user.getRole() == User.Role.WAITER) {
            customer.setHasMenu(hasMenu);
            customer.setName(name);
            customer.setWaiterId(user.getId());
            if (customer.getOrderId() == null) {
                customer.setOrderId(orderService.createOrder(id, waiterId).getId());
            }
        }
        return repository.save(customer);
    }

    public void reset() {
        repository.deleteAll();
    }

}
