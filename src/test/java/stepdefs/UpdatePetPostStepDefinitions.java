package stepdefs;

import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.response.Response;
import model.request.Pet;
import pageObjects.AddPetPostPageObject;
import pageObjects.GetPetPageObject;
import pageObjects.UpdatePetPutPageObject;

import java.io.IOException;
/**
 * @author Nandlal Dhande
 *
 */
public class UpdatePetPostStepDefinitions {

	private World world;
	private GetPetPageObject getPetPageObject = new GetPetPageObject();
	private UpdatePetPutPageObject updatePetPutPageObject = new UpdatePetPutPageObject();
	private AddPetPostPageObject addPetPostPageObject = new AddPetPostPageObject();
	Gson gson = new Gson();
	public UpdatePetPostStepDefinitions(World world) {
		this.world = world;
	}

	@When("^user update the \"([^\"]*)\" of the existing pet using update post service$")
	public void userUpdateTheOfTheExistingPet(String newName) throws Throwable {
		Pet pet =gson.fromJson(world.getRequestString(),Pet.class);
		pet.setName(newName);
		world.setRequestString(gson.toJson(pet));
		updatePetPutPageObject.updatePetWithFormParam(newName,world.getResponse().jsonPath().getInt("id")).getBody().asString();
	}
}
