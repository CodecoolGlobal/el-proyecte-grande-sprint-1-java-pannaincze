package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.user.NewUserDTO;
import com.codecool.sportbuddyfinder.model.payload.TokenResponse;
import com.codecool.sportbuddyfinder.service.SportService;
import com.codecool.sportbuddyfinder.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void registerUserIsASuccess() throws Exception {
        //TODO Java 8 date/time type not supported by default
        int[] interests = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        NewUserDTO user = new NewUserDTO("Kenny", "ken@ken.com", "111", interests, LocalDate.now());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        String jsonUser = objectWriter.writeValueAsString(user);

        when(userService.addUser(user)).thenReturn(TokenResponse.builder().build());
        this.mockMvc.perform(post("/users").content(jsonUser).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}