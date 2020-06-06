Feature: Get Pet Service Tests
	This feature includes tests that test the Get Pet RESTFul service
	@smokeTest
	Scenario Outline:  Users are able get pet using PetID
		Given The PetStore application is available
		When user add the pet "<petDetails>"
		Then verify Status code of response is 200 Ok
		And verify user get expected response
		And verify user is able to retrieve the recently added pet using petID
		Examples:
			|petDetails       |
			|addPetDetails    |