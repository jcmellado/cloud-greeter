package com.inmensia.greeter.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GreetingResponse", description = "Greeting response")
public class GreetingResponse {

  private Integer port;

  private String message;

  public GreetingResponse() {
  }

  public GreetingResponse(final Integer port, final String message) {
    this.port = port;
    this.message = message;
  }

  @ApiModelProperty(required = true, notes = "The port")
  public Integer getPort() {
    return port;
  }

  public void setPort(final Integer port) {
    this.port = port;
  }

  @ApiModelProperty(required = true, notes = "The message")
  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}