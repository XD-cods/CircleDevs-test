package com.vlad.circledevs_test;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankControllerTest {
  @LocalServerPort
  private int port;
  private static int testId;

  @BeforeEach
  void setUp() {
    RestAssured.port = port;
  }

  @Test
  @Order(1)
  public void testGetAllBanks() {
    given()
            .when()
            .get("/bank")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON);
  }

  @Test
  @Order(2)
  public void testAddBank() {
    BankDTO bankDTO = new BankDTO();
    bankDTO.setTitle("New Bank");

    testId = given()
            .contentType(ContentType.JSON)
            .body(bankDTO)
            .when()
            .post("/bank")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("title", equalTo("New Bank"))
            .extract().path("id");
  }

  @Test
  @Order(3)
  public void testGetBankById() {
    given()
            .when()
            .get("/bank/{id}", testId)
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("id", equalTo(testId));
  }

  @Test
  @Order(4)
  public void testAddBankAlreadyExists() {
    BankDTO bankDTO = new BankDTO();
    bankDTO.setTitle("New Bank");

    given()
            .contentType(ContentType.JSON)
            .body(bankDTO)
            .when()
            .post("/bank")
            .then()
            .statusCode(HttpStatus.CONFLICT.value());
  }

  @Test
  @Order(5)
  public void testDeleteBank() {
    given()
            .when()
            .delete("/bank/{id}", testId)
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value());
  }
}
