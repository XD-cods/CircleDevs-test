package com.vlad.circledevs_test;

import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTest {

  private static int testId;

  @BeforeEach
  void setUp() {
    RestAssured.port = 8080;
  }

  @Test
  @Order(1)
  public void testGetAllCustomers() {
    given()
            .when()
            .get("/customer")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON);
  }

  @Test
  @Order(2)
  public void testAddCustomer() {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setFirstName("John");
    customerDTO.setLastName("Doe");

    testId = given()
            .contentType(ContentType.JSON)
            .body(customerDTO)
            .when()
            .post("/customer")
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .extract().path("id");
  }

  @Test
  @Order(3)
  public void testGetCustomerById() {
    given()
            .when()
            .get("/customer/{id}", testId)
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("id", equalTo(testId));
  }

  @Test
  @Order(4)
  public void testDeleteCustomer() {
    given()
            .when()
            .delete("/customer/{id}", testId)
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value());

    given()
            .when()
            .get("/customer/{id}", testId)
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
  }
}
