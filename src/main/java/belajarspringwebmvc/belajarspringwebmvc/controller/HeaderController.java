package belajarspringwebmvc.belajarspringwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/hello/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String token) {
        if(token.equals("Reqi")) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
