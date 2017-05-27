package com.inmensia.greeter.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan(basePackages = { "com.inmensia.greeter.api" })
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
