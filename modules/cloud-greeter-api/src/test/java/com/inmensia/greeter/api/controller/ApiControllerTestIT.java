package com.inmensia.greeter.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ApiControllerTestIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGreeting_Ok() throws Exception {
    mockMvc.perform(get("/api/v1/greeting").contentType(MediaType.APPLICATION_JSON_UTF8)
        .param("name", "World"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Hello World!"));
  }

  @Test
  public void testGreeting_Ko() throws Exception {
    mockMvc.perform(get("/api/v1/greeting").contentType(MediaType.APPLICATION_JSON_UTF8)
        .param("name", "Hell"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Failed!"));
  }
}
