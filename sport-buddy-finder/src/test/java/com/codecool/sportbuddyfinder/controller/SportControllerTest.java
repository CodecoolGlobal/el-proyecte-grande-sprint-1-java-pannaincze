package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.service.SportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    @Test
    void getAllShouldReturnSportObjectsFromServiceWithExactValues() throws Exception {
        List<Sport> mockSports = Arrays.asList(new Sport(1,"Boxing"),new Sport(2,"Dancing"));

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        String jsonSports = objectWriter.writeValueAsString(mockSports);
        when(sportService.getAll()).thenReturn(mockSports);
        this.mockMvc.perform(get("/sports")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Boxing"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Dancing"));
    }
}