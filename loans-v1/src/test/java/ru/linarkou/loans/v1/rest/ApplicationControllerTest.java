package ru.linarkou.loans.v1.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.linarkou.loans.v1.service.ApplicationService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApplicationController.class)
class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationService service;

    @Test
    void getAllApplications() throws Exception {
        when(service.getAllApplications()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/v1/application"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}