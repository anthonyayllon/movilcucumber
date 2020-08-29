package com.movil.test.steps;

import com.movil.test.services.RestAssuredConfiguration;
import com.movil.test.utility.CommonServicesUtil;
import com.movil.test.utility.Constant;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;

public class ServiceCreateClientSteps {


    String strBaseUri = "https://api-alianzasdigitales-desa.azure-api.net/tetris/v1/accounts/savings";
    String strPath = "";
    String endPoint = "";
    String subCriptionKey = "";

    @Given("^I set the headers with subcriptionKey with \"([^\"]*)\"$")
    public void iSetTheHeadersWithSubcriptionKeyWith(String _subcription)  {
        subCriptionKey = _subcription;
    }


    @Then("^validate create customer quantity of \"([^\"]*)\"$")
    public void validateCreateCountClientOf(String _count)  {

        for(int i = 0; i<Integer.parseInt(_count);i++) {
            //Preparo la URI
            RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(strBaseUri, strPath);

            //Preparo el body para la peticion Post
            String strBody = CommonServicesUtil.getBodyContactData();
            //Lanzo la peticion post y recepciono en una response
            Response response = new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody).header(Constant.SUB_SCRIPTION, subCriptionKey), endPoint);

            System.out.println("\n/**************************************/");
            System.out.println("Codigo de respuesta del servidor: " + response.getStatusCode());
            Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        }
    }



}
