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
public class GetPetPageObject extends BasePageObject {
    private final String GET_PET_PATH = "v2/pet/";

    public String getPath() {
        return this.GET_PET_PATH;
    }

    public Response getPet(int petID) {
        String url = getBaseUrl() + this.getPath();
        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.GET_REQUEST, url+petID, "");
    }

}



