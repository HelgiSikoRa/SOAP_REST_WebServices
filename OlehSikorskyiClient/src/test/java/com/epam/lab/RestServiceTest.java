package com.epam.lab;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestServiceTest {
    RequestSpecification httpRequest;
    private static String jsonCheckBalance = "{\"summary\":{\"successMessage\":\"Successful operation \\u0027Check Balance\\u0027\"}}";
    private static String jsonStatusLine = "HTTP/1.1 200 OK";
    private final static Logger LOG = LogManager.getLogger(SoapServiceTest.class);

    @BeforeClass
    public void setURI() {
        RestAssured.baseURI = "http://localhost:8080/OlehSikorskyiService/rest/path";
        httpRequest = RestAssured.given();
    }

    @Test(description = "GET")
    public void getRequestExampleTest() throws JSONException {
        Response response = httpRequest.get("/checkBalance");
        ResponseBody body = response.getBody();
        Assert.assertEquals(body.asString(), jsonCheckBalance);
        LOG.info(String.format("REST: Response body equals expected: %s", body.asString()));
    }

    @Test(description = "GET")
    public void getStatusCodeTest() throws JSONException {
        Response response = httpRequest.get("/checkBalance");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Correct status code returned");
        LOG.info(String.format("REST: Correct status code returned: %d", statusCode));
    }

    @Test(description = "GET")
    public void getStatusLineTest() throws JSONException {
        Response response = httpRequest.get("/checkBalance");
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, jsonStatusLine, "Correct status code returned");
        LOG.info(String.format("REST: Correct status code returned: %s", statusLine));
    }
}