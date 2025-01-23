package belajarspringwebmvc.belajarspringwebmvc.controller;

import belajarspringwebmvc.belajarspringwebmvc.model.CreatePersonRequest;
import belajarspringwebmvc.belajarspringwebmvc.model.CreateSocialMediaRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Reqi");
        request.setMiddleName("Jumantara");
        request.setLastName("Hapid");
        request.setEmail("reqi@reqi.com");
        request.setPassword("password");
        request.setHobbies(List.of("Main game", "Fotografi", "Coding"));
        request.setSocialMedias(new ArrayList<>());
//        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "https://www.facebook.com/reqii"));
//        request.getSocialMedias().add(new CreateSocialMediaRequest("Twitter", "https://twitter.com/reqi"));

        String jsonReq = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonReq)
        ).andExpectAll(
                status().isOk(),
                content().json(jsonReq)
        );
    }

    @Test
    void createPersonError() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
//        request.setFirstName("Reqi");
        request.setMiddleName("Jumantara");
        request.setLastName("Hapid");
        request.setEmail("reqi@reqi.com");
//        request.setPassword("password");
        request.setHobbies(List.of("Main game", "Fotografi", "Coding"));
        request.setSocialMedias(new ArrayList<>());
//        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "https://www.facebook.com/reqii"));
//        request.getSocialMedias().add(new CreateSocialMediaRequest("Twitter", "https://twitter.com/reqi"));

        String jsonReq = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonReq)
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}