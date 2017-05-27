package com.inmensia.greeter.api.service;

import com.inmensia.greeter.api.model.GreetingResponse;

public interface GreeterService {

  GreetingResponse greeting(String name);
}
