package com.inmensia.greeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GreetingRequest", description = "Greeting request")
public class GreetingRequest {

  private String name;

  public GreetingRequest() {
  }

  public GreetingRequest(final String name) {
    this.name = name;
  }

  @ApiModelProperty(required = true, notes = "The name")
  public String getName() {
    return name;
  }
}