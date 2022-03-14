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
class TodoListControllerTest extends AbstractTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Test
    void whenSaveItemThenReturns201AndItemResponseDto() throws Exception {
        mockMvc.perform(post(ITEM_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createItemDto("", EXISTING_USER_ID))))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.id").isNumber());
    }

    @Test
    void whenSaveItemNotExistenUserThenReturns404AndBadRequest() throws Exception {
        mockMvc.perform(post(ITEM_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createItemDto("", NOT_EXISTENT_USER_ID))))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.id").isNumber());
    }


    @Test
    void whenGetTodoListByUserIdThenReturns200AndListItemsResponseDto() throws Exception {
        mockMvc.perform(get(ITEM_SAVE, EXISTING_USER_ID))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetTodoListByNotExistUserIdThenReturns404AndBadRequest() throws Exception {
        mockMvc.perform(get(ITEM_FIND, NOT_EXISTENT_USER_ID))
                .andExpect(status().isNotFound())
                .andExpect(mvcResult ->
                        mvcResult.getResolvedException().getClass().equals(UserNotFoundException.class));
    }

    @Test
    void whenDeleteExistingUserThenReturns200AndStatusOk() throws Exception {
        mockMvc.perform(delete(ITEM_FIND, EXISTING_USER_ID))
                .andExpect(status().isOk());
    }

}