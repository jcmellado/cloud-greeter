package com.inmensia.greeter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmensia.greeter.model.GreetingRequest;

@SpringBootTest(properties = { "server.port=0", "spring.cloud.config.enabled=false", "eureka.client.enabled=false" })
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GreetingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void testGreeting_Ok() throws Exception {
    final GreetingRequest request = new GreetingRequest("World");

    mockMvc.perform(post("/api/v1/greeting").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(mapper.writeValueAsString(request)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.port").exists())
        .andExpect(jsonPath("$.message").value("Hello World!"));
  }
}
