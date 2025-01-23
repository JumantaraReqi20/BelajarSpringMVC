package belajarspringwebmvc.belajarspringwebmvc.controller;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
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
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "Reqi")
                        .param("password", "admin")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Login Success")),
                cookie().value("username", Matchers.equalTo("Reqi"))
        );
    }

    @Test
    void loginError() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "Reqi")
                        .param("password", "admin1")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("Login Failed"))
        );
    }

    @Test
    void getUserTest() throws Exception {
        mockMvc.perform(
                get("/auth/login")
                        .cookie(new Cookie("username", "Reqi"))
                //karena cookie itu biasanya dikirim oleh browser, jadi kita perlu membuat simulasi seolah-olah cookie nya ada
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Reqi"))
        );
    }
}