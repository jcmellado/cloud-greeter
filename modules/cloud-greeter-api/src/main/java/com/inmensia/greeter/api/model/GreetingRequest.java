package com.inmensia.greeter.api.model;

public class GreetingRequest {

  private String name;

  public GreetingRequest() {
  }

  public GreetingRequest(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}