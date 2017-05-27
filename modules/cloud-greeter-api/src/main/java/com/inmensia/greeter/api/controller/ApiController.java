package com.inmensia.greeter.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inmensia.greeter.api.model.GreetingResponse;
import com.inmensia.greeter.api.service.GreeterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/api/v1")
public class ApiController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

  private final GreeterService greeterService;

  @Autowired
  public ApiController(final GreeterService greeterService) {
    this.greeterService = greeterService;
  }

  @ApiOperation(value = "greeting", response = ApiResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = GreetingResponse.class) })
  @RequestMapping(method = RequestMethod.GET, value = "/greeting")
  public GreetingResponse greeting(
      @ApiParam(value = "name", required = true) @RequestParam(name = "name") final String name) {

    LOGGER.debug("Name: {}", name);

    final GreetingResponse response = greeterService.greeting(name);

    LOGGER.debug("Port: {}", response.getPort());
    LOGGER.debug("Message: {}", response.getMessage());

    return response;
  }
}
