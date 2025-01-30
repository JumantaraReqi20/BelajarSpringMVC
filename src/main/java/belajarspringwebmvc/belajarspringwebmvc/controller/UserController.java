package belajarspringwebmvc.belajarspringwebmvc.controller;

import belajarspringwebmvc.belajarspringwebmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.xml.xpath.XPath;

@Controller
public class UserController {

    @GetMapping (path = "/user/current")
    @ResponseBody
    public String getUser(@SessionAttribute(name = "user") User user){
        return "Hello " + user.getUsername();
    }
}
