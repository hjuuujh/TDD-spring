package com.example.section1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

// api test만들고 springboot test 붙여서 랜덤포트사용
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    private int port;

    // before 에서 rest assured가 받아서 사용할 수 있도록
    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

}
