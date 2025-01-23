package belajarspringwebmvc.belajarspringwebmvc.controller;

import belajarspringwebmvc.belajarspringwebmvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createPerson (@ModelAttribute CreatePersonRequest request) {
        return new StringBuilder().append("Success create person with name ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(", ")
                .append("with email ")
                .append(request.getEmail()).append(" ")
                .append("and password ")
                .append(request.getPassword()).toString();
    }
}
