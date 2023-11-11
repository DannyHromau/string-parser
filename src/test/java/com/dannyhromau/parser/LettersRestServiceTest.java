package com.dannyhromau.parser;

import com.dannyhromau.parser.api.dto.ErrorMessageDto;
import com.dannyhromau.parser.service.LettersService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.yml")
public class LettersRestServiceTest {

    @LocalServerPort
    private int port;
    @Value("${host}")
    private String host;
    @Value("${lettersMapping}")
    private String requestMapping;
    @Value("${countMapping}")
    private String countMapping;
    @Value("${length_max}")
    private int stringLengthMax;
    @Autowired
    private LettersService lettersService;


    @Test
    void check_simple_string_test() {
        String simpleStr = "aaaaabcccc";
        String expectedResult = "\"a\": 5, \"c\": 4, \"b\": 1";
        Response response = given()
                .port(port)
                .when()
                .contentType(ContentType.TEXT)
                .body(simpleStr)
                .post(host + port + requestMapping + countMapping)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        Assertions.assertEquals(expectedResult, response.asString());
    }

    @Test
    void check_empty_string_test() {
        String simpleStr = "";
        given()
                .port(port)
                .when()
                .contentType(ContentType.TEXT)
                .body(simpleStr)
                .post(host + port + requestMapping + countMapping)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .extract().response();
    }

    @Test
    void check_whitespace_string_test() {
        String simpleStr = "\t" + "\r" + "\n" + " ";
        String expectedResult = "\"\t\": 1, \"\r\": 1, \"\n\": 1, \" \": 1";
        Response response = given()
                .port(port)
                .when()
                .contentType(ContentType.TEXT)
                .body(simpleStr)
                .post(host + port + requestMapping + countMapping)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        Assertions.assertEquals(expectedResult, response.asString());
    }

    @Test
    void check_when_string_length_more_than_max_test() {
        StringBuilder buffer1 = new StringBuilder();
        ReflectionTestUtils.setField(lettersService, "maxInputLength", stringLengthMax);
        for (int i = 0; i <= stringLengthMax; i++) {
            buffer1.append('a');
        }
        ErrorMessageDto expectedResult = new ErrorMessageDto("Input length is too long");
        Response response = given()
                .port(port)
                .when()
                .contentType(ContentType.TEXT)
                .body(buffer1.toString())
                .post(host + port + requestMapping + countMapping)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .extract().response();
        Assertions.assertEquals(expectedResult.getMessage(), response.body().jsonPath().getString("message"));
    }
}
