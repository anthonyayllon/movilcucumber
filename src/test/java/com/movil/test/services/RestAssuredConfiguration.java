package com.movil.test.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RestAssuredConfiguration {



    public RequestSpecification getRequestSpecification(String baseUri, String basePAth) {

        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePAth;

        return RestAssured.given().contentType(ContentType.JSON);
    }


    public Response getResponsePost(RequestSpecification requestSpecification, String endpoint){

        requestSpecification.log().all();
        Response response = requestSpecification.post(endpoint);
        response.then().log().all();
        return response;
    }

    public Response getResponseGet(RequestSpecification requestSpecification, String endpoint){

        requestSpecification.log().all();
        Response response = requestSpecification.get(endpoint);
        response.then().log().all();
        return response;
    }

    public Response getResponsePut(RequestSpecification requestSpecification, String endpoint, int id){

        requestSpecification.log().all();
        Response response = requestSpecification.put(endpoint+id);
        response.then().log().all();
        return response;
    }

    public Response getResponseDelete(RequestSpecification requestSpecification, String endpoint, int id){

        requestSpecification.log().all();
        Response response = requestSpecification.delete(endpoint+id);
        response.then().log().all();
        return response;
    }






}
