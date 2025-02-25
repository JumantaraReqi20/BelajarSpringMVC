package belajarspringwebmvc.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Reqi")
                        .param("middleName", "Jumantara")
                        .param("lastName", "Hapid")
                        .param("email", "reqi.jumantara@gmail.com")
                        .param("password", "12345")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString(
                        "Success create person with name Reqi Jumantara Hapid," +
                                " with email reqi.jumantara@gmail.com and password 12345"
                ))
        );
    }

    @Test
    void errorCreatePerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Reqi")
                        .param("middleName", "Jumantara")
                        .param("lastName", "Hapid")
                        .param("email", "reqi.jumantara@gmail.com")
                        //.param("password", "12345")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data")
                )
        );
    }
}