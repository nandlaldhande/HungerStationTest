package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.BasePageObject;
import utils.JsonUtils;

public class CommonDefinitions {
	
	private World world;
	private BasePageObject be = new BasePageObject();
	
	public CommonDefinitions(World world) {
		this.world = world;
	}
	
	@Given("^The PetStore application is available$")
	public void thePetStoreApplicationIsAvailable() {
		String url = be.getBaseUrl();
		be.sendRequest(null, BasePageObject.GET_REQUEST, url, null).then().statusCode(200);
	}

	@Then("^the requests response will contain the value '(.*?)' for the '(.*?)' field$")
	public void i_will_be_able_to_run_connected_step_definitions(String val, String key) {
		be.verifyResponseKeyValues(key, val, world.getResponse());
	}

	@And("^verify user get expected response \"([^\"]*)\"$")
	public void verifyUserGetExpected(String fileName) throws Throwable {
		Assert.assertTrue(JsonUtils.getExpectedJsonObjectForGivenFile(fileName).equals(JsonUtils.getActualJsonObject(world.getResponse().asString())));
	}

	@Then("^verify Status code of response is (\\d+) Ok$")
	public void verifyStatusCodeOfResponseIsOk(int arg0) {
		Assert.assertEquals(world.getResponse().getStatusCode(),200);
	}
}
