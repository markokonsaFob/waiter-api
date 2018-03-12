package ee.fobsolutions.waiter.controllers;

import ee.fobsolutions.waiter.models.core.Response;
import ee.fobsolutions.waiter.service.AuthenticationService;
import ee.fobsolutions.waiter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/customers")
    @ResponseBody
    Response getCustomers() {
        return new Response(customerService.getAllCustomers());
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    @ResponseBody
    Response createCustomer(
            @RequestParam("name") String name
    ) {
        return new Response(customerService.addCustomer(name));
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    @ResponseBody
    Response updateCustomerInformation(
            @RequestParam("id") String id,
            @RequestParam("hasMenu") boolean hasMenu,
            @RequestParam("name") String name,
            @RequestParam("waiterId") String waiterId
    ) {
        return new Response(customerService.updateCustomer(id, name, waiterId, hasMenu));
    }

}
