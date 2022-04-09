package com.practiceTasks.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class api_PlaceHolderStepDefinitions {

    Response response;
    Map<String,Object> postRequest;

    @When("User sends a post request to jsonplaceholder api")
    public void user_sends_a_post_request_to_jsonplaceholder_api() {
        postRequest = new HashMap<>();
        postRequest.put("userId",1);
        postRequest.put("id",1);
        postRequest.put("title","Hello World!");
        postRequest.put("body","I will break the bad");

        response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .and().body(postRequest).when().post("https://jsonplaceholder.typicode.com/posts");
    }

    @Then("Verify status code is {int}")
    public void verify_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }

    @Then("Verify userId, title and body are matched with request body")
    public void verify_user_id_title_and_body_are_matched_with_request_body() {
        Map<String,Object> responseBody = response.body().as(Map.class);
        assertEquals(postRequest.get("userId"),responseBody.get("userId"));
        assertEquals(postRequest.get("title"),responseBody.get("title"));
        assertEquals(postRequest.get("body"),responseBody.get("body"));
    }
}
