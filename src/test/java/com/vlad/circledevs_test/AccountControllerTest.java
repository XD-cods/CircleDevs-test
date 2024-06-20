package com.vlad.circledevs_test;

import com.vlad.circledevs_test.models.DTO.AccountDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountControllerTest {

  private static int testId;

  @BeforeEach
  public void setup() {
    RestAssured.port = 8080;
  }

  @Test
  @Order(1)
  public void testGetAllCustomerAccount() {
    given()
            .when()
            .get("/account")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON);
  }

  @Test
  @Order(2)
  public void testAddAccount() {
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setUsername("testuser");
    accountDTO.setPassword("testpass");
    accountDTO.setCashAmount(BigDecimal.valueOf(1000));

    testId = given()
            .contentType(ContentType.JSON)
            .body(accountDTO)
            .when()
            .post("/account")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .extract().path("id");

  }

  @Test
  @Order(3)
  public void testGetCustomerAccountById() {
    given()
            .when()
            .get("/account/{id}", testId)
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("id", equalTo(testId));
  }

  @Test
  @Order(4)
  public void testAddAccountAlreadyExists() {
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setUsername("testuser");
    accountDTO.setPassword("testpass");
    accountDTO.setCashAmount(BigDecimal.valueOf(1000));

    given()
            .contentType(ContentType.JSON)
            .body(accountDTO)
            .when()
            .post("/account")
            .then()
            .statusCode(HttpStatus.CONFLICT.value());
  }

  @Test
  @Order(5)
  public void testDeleteAccount() {
    given()
            .when()
            .delete("/account/{id}", testId)
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value());

    given()
            .when()
            .get("/account/{id}", testId)
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
  }
}
