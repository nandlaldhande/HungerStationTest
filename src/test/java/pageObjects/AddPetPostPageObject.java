package pageObjects;

import gherkin.deps.com.google.gson.Gson;
import io.restassured.response.Response;
import model.request.*;
import org.junit.Assert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AddPetPostPageObject extends BasePageObject {
    private final String HOTEL_ENDPOINT_PATH = "v2/pet";
    private Pet pet;
    Gson gson = new Gson();

    public String getPath() {
        return this.HOTEL_ENDPOINT_PATH;
    }

    public Response searchHotelWithBody(String body) {
        String url = getBaseUrl() + this.getPath();
        getRequestWithJSONHeaders().body(body);

        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.POST_REQUEST, url, body);
    }

    public Response addPet(String body) {
        String url = getBaseUrl() + this.getPath();
        getRequestWithJSONHeaders().body(body);
        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.POST_REQUEST, url, body);
    }

    public Category setCategory(String name,int id) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }

    public Tags setTags(String name,int id) {
       Tags tags = new Tags();
       tags.setId(id);
        tags.setName(name);
       return tags;
    }

    public Pet setPet(String petDetails) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/inputJsonFiles/" + petDetails + ".json"));
        Pet pet =gson.fromJson(reader,Pet.class);
        Random rand = new Random();
       // Obtain a number between [0 - 999999999].
        int randomID = rand.nextInt(999999999);
        pet.setId(randomID);
        return pet;
    }

    public Pet setPetWithGivenString(String petDetails) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/inputJsonFiles/" + petDetails + ".json"));
        Pet pet =gson.fromJson(reader,Pet.class);
        Random rand = new Random();
        // Obtain a number between [0 - 999999999].
        int randomID = rand.nextInt(999999999);
        pet.setId(randomID);
        return pet;
    }
}
