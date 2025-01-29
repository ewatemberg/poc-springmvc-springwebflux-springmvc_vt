package com.example.spring.mvc.load;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;


import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;


public class PocMvcLoadSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json");

    ScenarioBuilder myFirstScenario = scenario("POC MVC Scenario")
            .exec(http("Request 1")
                    .get("/user/email/emilio.watemberg@domain.com"));

    {
        setUp(
                myFirstScenario.injectOpen(
                        rampUsers(50).during(15), //rampUsers(50).during(30)
                        constantUsersPerSec(200).during(30) //constantUsersPerSec(100).during(90)
                )
        ).protocols(httpProtocol);
    }

}
