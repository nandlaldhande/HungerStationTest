package stepdefs;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pageObjects.GetPetPageObject;
/**
 * @author Nandlal Dhande
 *
 */
public class GetPetStepDefinitions {

	private World world;
	private GetPetPageObject getPetPageObject = new GetPetPageObject();
	public GetPetStepDefinitions(World world) {
		this.world = world;
	}

	@And("^verify user is able to retrieve the recently added pet using petID$")
	public void verifyGetPet() {
		Assert.assertEquals(getPetPageObject.getPet(world.getResponse().jsonPath().getInt("id")).getBody().asString(),world.getResponse().getBody().asString());
	}

	@And("^verify the update has been reflected as expected$")
	public void verifyLGetPet() {
		Assert.assertEquals(getPetPageObject.getPet(world.getResponse().jsonPath().getInt("id")).getBody().asString(),world.getRequestString());
	}
}
