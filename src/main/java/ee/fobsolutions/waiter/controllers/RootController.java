package ee.fobsolutions.waiter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by FOB Solutions
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public String landingPage(Model model, HttpServletRequest request) {
        return "index";
    }


}
