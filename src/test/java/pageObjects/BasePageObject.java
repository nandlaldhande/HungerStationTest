package pageObjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author Nandlal Dhande
 *
 */
public class BasePageObject {
    public static final int SUCCESS_STATUS_CODE = 200;
    public static final int GET_REQUEST = 0;
    public static final int POST_REQUEST = 1;
    public static final int DELETE_REQUEST = 3;
    public static final int PUT_REQUEST = 4;
    public static final int POST_REQUEST_FORM_PARAM = 5;

    protected final String base_url = "https://petstore.swagger.io/";
    private final String mediaType = "application/json";

    public BasePageObject() {
    }

    public void verifyResponseKeyValues(String key, String val, Response r) {
        String keyValue = r.jsonPath().getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyResponseStatusValue(Response response, int expectedCode) {
        assertThat(response.getStatusCode(), is(expectedCode));
    }

    public String getBaseUrl() {
        return this.base_url;
    }

    public RequestSpecification getRequestWithJSONHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", mediaType);
        r.header("Accept", mediaType);
        return r;
    }

    public Response sendRequest(RequestSpecification request, int requestType, String url, String body) {
        Response response;

        //set response switch based on request type
        switch (requestType) {
            case BasePageObject.GET_REQUEST:
                response = null == request ? RestAssured.when().get(url) : request.get(url);
                break;
            case BasePageObject.POST_REQUEST:
                response = null == request ? RestAssured.when().post(url) : request.body(body).post(url);
                break;
            case BasePageObject.DELETE_REQUEST:
                response = null == request ? RestAssured.when().delete(url) : request.delete(url);
                break;
            case BasePageObject.PUT_REQUEST:
                response = null == request ? RestAssured.when().put(url) : request.body(body).put(url);
                break;
            case BasePageObject.POST_REQUEST_FORM_PARAM:
                response = null == request ? RestAssured.when().post(url) : request.post(url);
                break;
            default:
                response = RestAssured.when().post(url);
                break;
        }
        return response;
    }

    public String responseType(Response response) {
        return response.jsonPath().get("type");
    }
}
