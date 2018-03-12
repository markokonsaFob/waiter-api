package ee.fobsolutions.waiter.controllers;

import ee.fobsolutions.waiter.models.User;
import ee.fobsolutions.waiter.models.core.Response;
import ee.fobsolutions.waiter.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    Response login(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        return new Response(authenticationService.authenticate(username, password, request));
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    @ResponseBody
    Response logout(
            HttpServletRequest request
    ) {
        return new Response(authenticationService.logout(request));
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    Response registerUser(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("role") User.Role role
    ) {
        if (authenticationService.isAdmin(request)) {
            return new Response(authenticationService.register(username, password, password2, role));
        }
        return new Response("Failed to register!");
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    Response updateUser(
            HttpServletRequest request,
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("role") User.Role role
    ) {
        if (authenticationService.isAdmin(request)) {
            return new Response(authenticationService.update(id, password, password2, role));
        }
        return new Response("Cannot update user!");
    }

}
