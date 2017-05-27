package com.inmensia.greeter.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inmensia.greeter.model.GreetingRequest;
import com.inmensia.greeter.model.GreetingResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/api/v1")
public class GreetingController {

  private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

  @RequestMapping(method = RequestMethod.POST, value = "/greeting")
  @ApiOperation(value = "greeting", response = GreetingResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = GreetingResponse.class) })
  public GreetingResponse greeting(
      @ApiParam(value = "request", required = true) @RequestBody(required = true) final GreetingRequest request,
      final HttpServletRequest httpRequest) {

    LOGGER.debug("Received {}", request);

    return new GreetingResponse(httpRequest.getServerPort(), "Hello " + request.getName() + "!");
  }
}