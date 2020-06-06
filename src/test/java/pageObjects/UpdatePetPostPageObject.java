/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package pageObjects;
import io.restassured.response.Response;

/**
 * @author Nandlal Dhande
 *
 */
public class UpdatePetPostPageObject extends BasePageObject {
    private final String UPDATE_PET_PATH = "v2/pet";

    public String getPath() {
        return this.UPDATE_PET_PATH;
    }

    public Response updatePet(String body) {
        String url = getBaseUrl() + this.getPath();
        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.PUT_REQUEST, url, body);
    }
}



