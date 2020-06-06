Feature: Update Pet Put Service Tests
	This feature includes tests that test the update Pet put service
	@smokeTest
	Scenario Outline:  Users are able to update details of existing pet from PET STORE.
		Given The PetStore application is available
		When user add the pet "<petDetails>"
		Then verify Status code of response is 200 Ok
		When user update the "<name>" of the existing pet
		Then verify the update has been reflected as expected
		Examples:
			|petDetails       |name  |
			|addPetDetails    |Samba|