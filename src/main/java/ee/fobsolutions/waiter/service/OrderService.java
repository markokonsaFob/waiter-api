package ee.fobsolutions.waiter.service;

import ee.fobsolutions.waiter.dao.MenuItemRepository;
import ee.fobsolutions.waiter.dao.OrderRepository;
import ee.fobsolutions.waiter.models.Order;
import ee.fobsolutions.waiter.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FOB Solutions
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public List<Order> getMyOrders(HttpServletRequest request) {
        List<Order> orders = new ArrayList<>();
        Session session = authenticationService.getSession(request);
        if (session != null && authenticationService.isLoggedIn(request) && authenticationService.isWaiter(request)) {
            for (Order order : repository.findAll()) {
                if (order.getWaiterId().equals(session.getUserId())) {
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    public Order createOrder(String customerId, String waiterId) {
        return repository.save(new Order(customerId, waiterId));
    }

    public Object updateOrder(String id, Order.Status status, List<String> itemIds, String waiterId) {

        Order order = repository.findById(id);

        if (waiterId.equals(order.getWaiterId())) {
            order.setStatus(status);
            order.getItems().clear();

            for (String itemId : itemIds) {
                order.addItemToOrder(menuItemRepository.findById(itemId));
            }
            return repository.save(order);
        } else {
            return new Error("Not a correct waiter!");
        }
    }

    public void reset() {
        repository.deleteAll();
    }

}
