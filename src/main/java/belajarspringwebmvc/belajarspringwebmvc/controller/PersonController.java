package belajarspringwebmvc.belajarspringwebmvc.controller;

import belajarspringwebmvc.belajarspringwebmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Objects;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createPerson (@ModelAttribute @Valid CreatePersonRequest request,
                                BindingResult bindingResult) {

        List<FieldError> errors = bindingResult.getFieldErrors();

        if (!errors.isEmpty()) {
            //error
            errors.forEach(fieldError -> {
               System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You send invalid data");
        }

        System.out.println(request);

        String response = new StringBuilder().append("Success create person with name ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(", ")
                .append("with email ")
                .append(request.getEmail()).append(" ")
                .append("and password ")
                .append(request.getPassword()).toString();

        return ResponseEntity.ok(response);
    }
}
