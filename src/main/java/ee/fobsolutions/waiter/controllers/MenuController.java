package ee.fobsolutions.waiter.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import ee.fobsolutions.waiter.models.core.Response;
import ee.fobsolutions.waiter.service.AuthenticationService;
import ee.fobsolutions.waiter.service.MenuService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/menu")
    @ResponseBody
    Response getMenu() throws JsonProcessingException {
        return new Response(menuService.getFullMenu());
    }

    @RequestMapping("/menu/salads")
    @ResponseBody
    Response getSaladsMenu() throws JsonProcessingException {
        return new Response(menuService.getMenuByName(MenuService.MenuType.SALADS));
    }

    @RequestMapping("/menu/mains")
    @ResponseBody
    Response getMainCourses() throws JsonProcessingException {
        return new Response(menuService.getMenuByName(MenuService.MenuType.MAINS));
    }

    @RequestMapping("/menu/soups")
    @ResponseBody
    Response getSoups() throws JsonProcessingException {
        return new Response(menuService.getMenuByName(MenuService.MenuType.SOUPS));
    }

    @RequestMapping("/menu/desserts")
    @ResponseBody
    Response getDessertsMenu() throws JsonProcessingException {
        return new Response(menuService.getMenuByName(MenuService.MenuType.DESSERTS));
    }

    @RequestMapping("/menu/drinks")
    @ResponseBody
    Response getDrinksMenu() throws JsonProcessingException {
        return new Response(menuService.getMenuByName(MenuService.MenuType.DRINKS));
    }

}
