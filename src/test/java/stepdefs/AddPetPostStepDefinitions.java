package stepdefs;

import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import model.request.Pet;
import org.junit.Assert;
import pageObjects.AddPetPostPageObject;

public class AddPetPostStepDefinitions {

	private World world;
	private AddPetPostPageObject addPetPostPageObject =new AddPetPostPageObject();

	public AddPetPostStepDefinitions(World world) {
		this.world = world;
	}

	@When("^user add the pet \"([^\"]*)\"$")
	public void userAddThePet(String petDetails) throws Throwable {
		Pet pet = new Pet();
		pet = addPetPostPageObject.setPet(petDetails);
		world.setRequestString(new Gson().toJson(pet));
		world.setResponse(addPetPostPageObject.addPet(new Gson().toJson(pet)));
		}

	@And("^verify user get expected response$")
	public void verifyUserGetExpectedResponse() {
		Assert.assertEquals(world.getRequestString(),world.getResponse().asString());
	}
}
