/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package pageObjects;


import io.restassured.response.Response;

import java.util.Arrays;

/**
 * @author Nandlal Dhande
 *
 */
public class UpdatePetPutPageObject extends BasePageObject {
    private final String UPDATE_PET_PATH = "v2/pet/";

    public String getPath() {
        return this.UPDATE_PET_PATH;
    }

    public Response updatePet(String body) {
        String url = getBaseUrl() + this.getPath();
        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.PUT_REQUEST, url, body);
    }

    public Response updatePetWithFormParam(String newName,int petId) {
        String url = getBaseUrl() + this.getPath();
        return sendRequest(getRequestWithJSONHeaders().formParam("name", Arrays.asList(newName)).contentType("application/x-www-form-urlencoded"), BasePageObject.POST_REQUEST_FORM_PARAM, url+petId, "");
    }
}



