package com.movil.test.steps;


import com.movil.test.services.RestAssuredConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ServicesSteps {


    @Then("^Enviar los parametros usuario \"([^\"]*)\" y password \"([^\"]*)\"$")
    public void enviarLosParametrosUsuarioYPassword(String _user, String _pass) {

        String strBaseUri = "https://api.octoperf.com";
        String strPath = "/public/users";
        String endPoint = "/login";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);
        requestSpecification.queryParam("password", _user);
        requestSpecification.queryParam("username", _pass);

        //Response response = new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody).header(Constant.AUTHORIZATION,Settings.AuthorizationCert),EndPoint.POST_POLICY_MODIFICATION_CONTACT_DATA);
        Response response = new RestAssuredConfiguration().getResponsePost(requestSpecification,endPoint);
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }


    @Given("^a book exists with an isbn of \"([^\"]*)\"$")
    public void aBookExistsWithAnIsbnOf(String _codLibro)  {
        String strBaseUri = "https://www.googleapis.com/books/v1/volumes";
        String strPath = "";
        String endPoint = "";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);
        requestSpecification.queryParam("q",_codLibro);

        Response response = new RestAssuredConfiguration().getResponseGet(requestSpecification,endPoint);
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }


    @Given("^a book exists with an isbn of \"([^\"]*)\" get headers$")
    public void aBookExistsWithAnIsbnOfGetHeaders(String _codLibro) throws Throwable {

        String strBaseUri = "https://www.googleapis.com/books/v1/volumes";
        String strPath = "";
        String endPoint = "";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);
        requestSpecification.queryParam("q",_codLibro);

        Response response = new RestAssuredConfiguration().getResponseGet(requestSpecification,endPoint);
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        // Headers
        System.out.println("Get all header: \n"+response.getHeaders());
        System.out.println("\n/**************************************/");
        System.out.println("Get header Content-Type: \n"+response.getContentType());
        System.out.println("\n/**************************************/");
        System.out.println("Get header Content-Encoding: \n"+response.getHeader("Content-Encoding"));
        System.out.println("\n/**************************************/");
        System.out.println("Get header Date: \n"+response.getHeader("Date"));
        System.out.println("\n/**************************************/");

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }

    @Given("^a book exists with an isbn of \"([^\"]*)\" get body$")
    public void aBookExistsWithAnIsbnOfGetBody(String _codLibro) throws Throwable {
        String strBaseUri = "https://www.googleapis.com/books/v1/volumes";
        String strPath = "";
        String endPoint = "";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);
        requestSpecification.queryParam("q",_codLibro);

        Response response = new RestAssuredConfiguration().getResponseGet(requestSpecification,endPoint);
        System.out.println("\n/**************************************/");
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        System.out.println("\n/**************************************/");
        System.out.println("Get all getBody: "+response.getBody().print());
    }

    @Given("^response json get element of the body$")
    public void responseJsonGetElementOfTheBody() {
        String strBaseUri = "https://jsonplaceholder.typicode.com/users";
        String strPath = "";
        String endPoint = "";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);

        Response response = new RestAssuredConfiguration().getResponseGet(requestSpecification,endPoint);
        System.out.println("\n/**************************************/");
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        System.out.println("\n/**************************************/");
        List<String> listResponse = response.jsonPath().getList("$");
        System.out.println("Count of numbers records of the array list : \n"+listResponse.size());

        System.out.println("\n/**************************************/");
        System.out.println("Recuperar el valor de username de todas las entradas \n: "+response.jsonPath().getString("username"));

        System.out.println("\n/**************************************/");
        System.out.println("Recuperar el valor de username de la 1ra entrada : \n"+response.jsonPath().getString("username[0]"));

        System.out.println("\n/**************************************/");
        List<String> listEmail   = response.jsonPath().getList("email");
        System.out.println("Recuperar el valor de email de todas las entradas en una lista : \n"+listEmail.toString());


    }

    @Given("^response json get object of the body$")
    public void responseJsonGetObjectOfTheBody() {

        String strBaseUri = "https://jsonplaceholder.typicode.com/users";
        String strPath = "";
        String endPoint = "";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);

        Response response = new RestAssuredConfiguration().getResponseGet(requestSpecification,endPoint);
        System.out.println("\n/**************************************/");
        System.out.println("Codigo de respuesta: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        System.out.println("\n/**************************************/");
        Map<String,String> mapCompany = response.jsonPath().getMap("company[0]");
        System.out.println("Get name company de la 1ra entrada: \n"+mapCompany.get("name"));

        System.out.println("\n/**************************************/");
        List<Map<String,String>> listMapCompany = response.jsonPath().getList("company");
        System.out.println("Get name company de la 1ra entrada del listado de map: \n"+listMapCompany.get(0).get("name"));

    }

    @Then("^update the employe for id \"([^\"]*)\"$")
    public void updateTheEmployeForId(String _idEmploye) throws Throwable {

        String strBaseUri = "http://dummy.restapiexample.com/api/v1";
        String strPath = "";
        String endPoint = "/update/";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);

        JSONObject objEmployeParamter = new JSONObject();
        objEmployeParamter.put("name","Zion");
        objEmployeParamter.put("age",23);
        objEmployeParamter.put("salary",12000);

        String strBody = objEmployeParamter.toString();
        Response response = new RestAssuredConfiguration().getResponsePut(requestSpecification.body(strBody),endPoint,Integer.parseInt(_idEmploye));
        System.out.println("\n/**************************************/");
        System.out.println("Codigo de respuesta del servidor: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        System.out.println("\n/**************************************/");
        System.out.println("Get el parametro estado del cuerpo respuesta: "+response.jsonPath().getString("status"));
        Assert.assertEquals(response.jsonPath().getString("status"),"success");
    }


    @Then("^delete the employe for id \"([^\"]*)\"$")
    public void deleteTheEmployeForId(String _idEmploye) throws Throwable {

        String strBaseUri = "http://dummy.restapiexample.com/api/v1";
        String strPath = "";
        String endPoint = "/delete/";

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri,strPath);
        Response response = new RestAssuredConfiguration().getResponseDelete(requestSpecification,endPoint,Integer.parseInt(_idEmploye));

        System.out.println("\n/**************************************/");
        System.out.println("Codigo de respuesta del servidor: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        System.out.println("\n/**************************************/");
        System.out.println("Get status del cuerpo respuesta: "+response.jsonPath().getString("status"));


    }
}
