package belajarspringwebmvc.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDate() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/date").queryParam("date", "2025-01-15")
        ).andExpectAll(
                status().isOk(),
                MockMvcResultMatchers.content().string(Matchers.containsString("20250115"))
        );
    }
}