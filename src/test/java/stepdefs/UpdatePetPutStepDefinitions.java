package stepdefs;

import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import model.request.Pet;
import pageObjects.AddPetPostPageObject;
import pageObjects.GetPetPageObject;
import pageObjects.UpdatePetPutPageObject;

import java.io.IOException;
/**
 * @author Nandlal Dhande
 *
 */
public class UpdatePetPutStepDefinitions {

	private World world;
	private GetPetPageObject getPetPageObject = new GetPetPageObject();
	private UpdatePetPutPageObject updatePetPutPageObject = new UpdatePetPutPageObject();
	private AddPetPostPageObject addPetPostPageObject = new AddPetPostPageObject();
	Gson gson = new Gson();
	public UpdatePetPutStepDefinitions(World world) {
		this.world = world;
	}

	@When("^user update the '(.*?)' of the existing pet$")
	public void updatePetFromPetStore(String newName) throws IOException {
		Pet pet =gson.fromJson(world.getRequestString(),Pet.class);
		pet.setName(newName);
		world.setRequestString(gson.toJson(pet));
		world.setResponse(updatePetPutPageObject.updatePet(gson.toJson(pet)));
	}

	@When("^user update the \"([^\"]*)\" of the existing pet$")
	public void userUpdateTheOfTheExistingPet(String newName) throws Throwable {
		Pet pet =gson.fromJson(world.getRequestString(),Pet.class);
		pet.setName(newName);
		world.setRequestString(gson.toJson(pet));
		world.setResponse(updatePetPutPageObject.updatePet(gson.toJson(pet)));
	}
}
