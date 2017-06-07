# Spring Cloud sample application #

## Install ##

Download the projects:
```bash
git clone https://github.com/jcmellado/cloud-greeter.git
git clone https://github.com/jcmellado/cloud-greeter-config.git
```

## Running on Local Machine ##

In order to get this working you will need Java and Maven properly installed.

Change the current working directory:
```bash
cd cloud-greeter/modules
```

Run the following commands in different terminal windows.

Start up Config server:
```bash
cd cloud-greeter-config
mvn spring-boot:run "-DCLOUD_GREETER_CONFIG_PATH=../../../cloud-greeter-config"
```

Start up Eureka:
```bash
cd cloud-greeter-eureka
mvn spring-boot:run
```

Start up Greeter Service (two or more instances):
```bash
cd cloud-greeter-service
mvn spring-boot:run "-DCLOUD_GREETER_SERVICE_PORT=8200"
mvn spring-boot:run "-DCLOUD_GREETER_SERVICE_PORT=8201"
```

Start up Greeter API Gateway (two or more instances):
```bash
cd cloud-greeter-api
mvn spring-boot:run "-DCLOUD_GREETER_API_PORT=8300"
mvn spring-boot:run "-DCLOUD_GREETER_API_PORT=8301"
```

Start up Zuul:
```bash
cd cloud-greeter-zuul
mvn spring-boot:run
```

Start up Turbine:
```bash
cd cloud-greeter-turbine
mvn spring-boot:run
```

## Endpoints ##

The following endpoints will be available:

* Config Server endpoint at http://localhost:8100

  Try http://localhost:8100/health

* Eureka endpoint at http://localhost:8101

  It will show the Eureka dashboard.

* Greeter Service endpoints at http://localhost:8200 and http://localhost:8201

  Try http://localhost:8200/swagger-ui.html

  Try http://localhost:8201/swagger-ui.html

* Greeter API Gateway endpoints at http://localhost:8300 and http://localhost:8301

  Try http://localhost:8300/swagger-ui.html

  Try http://localhost:8301/swagger-ui.html

* Zuul endpoint at http://localhost:8103

  Try http://localhost:8103/greeter/api/v1/greeting?name=Juan

* Turbine endpoint at http://localhost:8102/hystrix

  It will show the Hystrix dashboard.

  Try http://localhost:8102/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8300%2Fhystrix.stream

  Try http://localhost:8102/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8102%2Fturbine.stream%3Fcluster%3DCLOUD-GREETER-API
