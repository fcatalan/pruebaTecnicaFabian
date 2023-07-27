package com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soaintCoopeuch.pruebaTecnicaFabian.application.dto.TaskDTO;
import com.soaintCoopeuch.pruebaTecnicaFabian.application.services.TaskServiceImpl;
import com.soaintCoopeuch.pruebaTecnicaFabian.domain.entities.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TaskControllerTest {

    @Autowired
    private MockMvc _mockMvc;

    @MockBean
    private TaskServiceImpl taskService;

    @Autowired
    private ObjectMapper _objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void validate_FindById_Is_ReturnOK() throws Exception {
        ResultActions response = this._mockMvc.perform(MockMvcRequestBuilders.get("/tasks/2")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }

    @Test
    void validate_getAll_Is_ReturnOK() throws Exception {
        ResultActions response = this._mockMvc.perform(MockMvcRequestBuilders.get("/tasks")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }

    @Test
    void validate_Add_Null_Data_Return_BadRequest() throws Exception {

        TaskDTO taskDTO1 = TaskDTO.builder().createdAt(LocalDateTime.now()).activated(true).build();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this._objectMapper.writeValueAsString(taskDTO1));

        MockHttpServletResponse response = this._mockMvc.perform(requestBuilder).andReturn().getResponse();

        assertEquals(400, response.getStatus());
    }

    @Test
    void validate_Update_Null_Data_Return_BadRequest() throws Exception {

        TaskDTO taskDTO1 = TaskDTO.builder().createdAt(LocalDateTime.now()).activated(true).build();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this._objectMapper.writeValueAsString(taskDTO1));

        MockHttpServletResponse response = this._mockMvc.perform(requestBuilder).andReturn().getResponse();

        assertEquals(400, response.getStatus());
    }

    @Test
    void delete(String path) throws Exception {

    }
}
