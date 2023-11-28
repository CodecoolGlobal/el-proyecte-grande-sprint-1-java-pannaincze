package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.service.SportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SportControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SportService sportService;
    @Test
    void getAllSportsReturnOK() throws Exception {
        List<Sport> mockSports = Arrays.asList(new Sport(1,"Boxing"),new Sport(2,"Dancing"));

        when(sportService.getAll()).thenReturn(mockSports);
        this.mockMvc.perform(get("/sports")).andDo(print()).andExpect(status().isOk());
    }
}