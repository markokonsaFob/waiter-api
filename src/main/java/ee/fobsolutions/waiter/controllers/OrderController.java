package ee.fobsolutions.waiter.controllers;

import ee.fobsolutions.waiter.models.Order;
import ee.fobsolutions.waiter.models.core.Response;
import ee.fobsolutions.waiter.service.AuthenticationService;
import ee.fobsolutions.waiter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/orders")
    @ResponseBody
    Response getCustomers(HttpServletRequest request) {
        if (authenticationService.isWaiter(request) && authenticationService.isLoggedIn(request)) {
            return new Response(orderService.getMyOrders(request));
        }
        return new Response("User is not a Waiter!");
    }

    @RequestMapping("/orders/all")
    @ResponseBody
    Response gettAllOrders(HttpServletRequest request) {
        if (authenticationService.isAdmin(request) && authenticationService.isLoggedIn(request)) {
            return new Response(orderService.getAllOrders());
        }
        return new Response("User is not a Admin!");
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    @ResponseBody
    Response updateOrder(
            HttpServletRequest request,
            @RequestParam("id") String id,
            @RequestParam("status") Order.Status status,
            @RequestParam("order") List<String> ids
    ) {
        if (authenticationService.isWaiter(request) && authenticationService.isLoggedIn(request)) {
            return new Response(orderService.updateOrder(id, status, ids, authenticationService.getLoggedInUser(request).getId()));
        }
        return new Response("User is not a Waiter!");
    }

}
