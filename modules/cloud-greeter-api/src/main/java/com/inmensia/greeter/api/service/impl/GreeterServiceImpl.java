package com.inmensia.greeter.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmensia.greeter.api.model.GreetingRequest;
import com.inmensia.greeter.api.model.GreetingResponse;
import com.inmensia.greeter.api.service.GreeterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@ConfigurationProperties(prefix = "cloud.greeter.api")
@Service
public class GreeterServiceImpl implements GreeterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(GreeterServiceImpl.class);

  private final RestTemplate restTemplate;

  private String greeterServiceUrl;

  @Autowired
  public GreeterServiceImpl(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void setGreeterServiceUrl(final String greeterServiceUrl) {
    this.greeterServiceUrl = greeterServiceUrl;
  }

  @Override
  @HystrixCommand(fallbackMethod = "fallbackGreeting")
  public GreetingResponse greeting(final String name) {
    LOGGER.debug("Name: {}", name);

    if ("Hell".equals(name)) {
      throw new NullPointerException();
    }

    final GreetingRequest request = new GreetingRequest(name);

    final GreetingResponse response = restTemplate.postForObject(greeterServiceUrl, request, GreetingResponse.class);

    LOGGER.debug("Port: {}", response.getPort());
    LOGGER.debug("Message: {}", response.getMessage());

    return response;
  }

  public GreetingResponse fallbackGreeting(final String name) {
    LOGGER.debug("Failed");

    return new GreetingResponse(null, "Failed!");
  }
}
