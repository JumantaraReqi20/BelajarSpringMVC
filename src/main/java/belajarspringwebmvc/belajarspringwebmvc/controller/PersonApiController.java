package belajarspringwebmvc.belajarspringwebmvc.controller;


import belajarspringwebmvc.belajarspringwebmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonApiController {

    @PostMapping("/api/person")
    @ResponseBody
    public CreatePersonRequest createPerson(@RequestBody @Valid CreatePersonRequest request) {
        return request;
    }
}
