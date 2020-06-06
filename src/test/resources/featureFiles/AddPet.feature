Feature: Add Pet Post Service Tests
	This feature includes tests that test the Add Pet RESTFul service
	@smokeTest
	Scenario Outline:  Users are able to add the pet using pet service
		Given The PetStore application is available
		When user add the pet "<petDetails>"
		Then verify Status code of response is 200 Ok
		And verify user get expected response
		Examples:
			|petDetails       |
			|addPetDetails    |