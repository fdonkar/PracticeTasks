package com.practiceTasks.stepdefinitions;

import com.practiceTasks.pages.POJO_PetShop.Category;
import com.practiceTasks.pages.POJO_PetShop.Pet;
import com.practiceTasks.pages.POJO_PetShop.Tag;
import com.practiceTasks.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class api_PetStore {

    Response response;
    Pet dog;
    Pet updatedDog;

    @When("User creates a new dog which name is {string}")
    public void user_creates_a_new_dog_which_name_is(String petName) {

        Category dogCategory = new Category((long)1,"dog");
        Tag dogTag = new Tag((long)1,"doggy");
        List<Tag> tagList = new ArrayList<>();
        tagList.add(dogTag);
        List<String> photoUrls = new ArrayList<>(Arrays.asList("String"));
        dog = new Pet((long)15,petName,dogCategory,photoUrls,tagList,"available");

        response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .and().body(dog).when().post(ConfigurationReader.get("petStore_api_baseUrl")+"/pet");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        Pet createdDog = response.body().as(Pet.class);
        System.out.println(createdDog.toString());
        assertEquals(dog.getName(),createdDog.getName());
    }

    @When("User update name of the dog as {string}")
    public void user_update_name_of_the_dog_as(String newName) {
        dog.setName(newName);
        response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .and().body(dog).when().put(ConfigurationReader.get("petStore_api_baseUrl")+"/pet");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        updatedDog = response.body().as(Pet.class);
        System.out.println(updatedDog.getName());
        assertEquals(dog.getName(),updatedDog.getName());
    }

    @When("User deletes created dog {string}")
    public void user_deletes_created_dog(String petName) {
        response = given().accept(ContentType.JSON).and().pathParam("id",updatedDog.getId())
                .when().delete(ConfigurationReader.get("petStore_api_baseUrl")+"/pet/{id}");
    }

    @Then("Verify the dog is deleted")
    public void verify_the_dog_is_deleted() {
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertEquals("Pet deleted",response.body().asString());
    }
}
