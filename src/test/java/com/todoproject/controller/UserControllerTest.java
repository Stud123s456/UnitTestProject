package com.todoproject.controller;

import com.todoproject.AbstractTest;
import com.todoproject.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class UserControllerTest extends AbstractTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Test
    void whenSaveUserThenReturns201AndUserResponseDto() throws Exception {
        mockMvc.perform(post(USER_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createUserDto("Ivan"))))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.id").isNumber());
    }

    @Test
    void whenSaveNullUserThenReturnsStatusBadRequest() throws Exception {
        mockMvc.perform(post(USER_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createUserDto(null))))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenFindExistingUserThenReturns200AndUserResponseDto() throws Exception {
        mockMvc.perform(get(USER_FIND, EXISTING_USER_ID))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").isNumber());
    }

    @Test
    void whenFindNotExistingUserThenReturnsUserNotFoundException() throws Exception {
        mockMvc.perform(get(USER_FIND, NOT_EXISTENT_USER_ID))
                .andExpect(status().isNotFound())
                .andExpect(mvcResult ->
                        mvcResult.getResolvedException().getClass().equals(UserNotFoundException.class));
    }

    @Test
    void whenDeleteExistingUserThenReturns200AndStatusOk() throws Exception {
        mockMvc.perform(delete(USER_FIND, EXISTING_USER_ID))
                .andExpect(status().isOk());
    }

}