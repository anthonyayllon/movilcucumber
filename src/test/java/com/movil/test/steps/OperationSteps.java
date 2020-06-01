package com.movil.test.steps;

import com.movil.test.pages.OperationPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OperationSteps {

    OperationPage op = new OperationPage();

    @Given("^Yo cargue el app VodQa$")
    public void yoCargueElAppVodQa() {
        System.out.println("Cargo el app VODQA");
    }

    @And("^Inserte usuario \"([^\"]*)\" y password \"([^\"]*)\"$")
    public void inserteUsuarioYPassword(String _user, String _pass) throws Throwable {
        op.inserteUsuarioYPassword(_user,_pass);
    }

    @And("^Me logueo$")
    public void meLogueo() {
        op.login();
    }


    @Then("^Scroll hacia abajo hasta encontrar la opción \"([^\"]*)\"$")
    public void scrollHaciaAbajoHastaEncontrarLaOpción(String _opcionBuscar) throws Throwable {
        op.searchOptionsOne(_opcionBuscar);
    }

    @Then("^Scroll hacia abajo hasta encontrar la descripción \"([^\"]*)\"$")
    public void scrollHaciaAbajoHastaEncontrarLaDescripción(String _opcionBuscar) throws Throwable {
        op.searchOptionsTwo(_opcionBuscar);
    }

    @Then("^Scroll hacia abajo a la vista \"([^\"]*)\"$")
    public void scrollHaciaAbajoALaVista(String _opcionBuscar) throws Throwable {
        op.searchOptionsThree(_opcionBuscar);
    }

    @Then("^Scroll hacia abajo a la vista description \"([^\"]*)\"$")
    public void scrollHaciaAbajoALaVistaDescription(String _opcionBuscar) throws Throwable {
        op.searchOptionsFour(_opcionBuscar);
    }

    @Then("^Scroll hacia abajo por cantidad desplazamiento swipe \"([^\"]*)\"$")
    public void scrollHaciaAbajoPorCantidadDesplazamientoSwipe(String _opcionBuscar) throws Throwable {
        op.searchOptionsFive(_opcionBuscar);
    }

    @Then("^Scroll hacia abajo por coordenadas swipe$")
    public void scrollHaciaAbajoPorCoordenadasSwipe() {
        op.searchOptionsSix();
    }

    @Then("^Scroll hacia abajo por text \"([^\"]*)\" y fin \"([^\"]*)\"$")
    public void scrollHaciaAbajoPorTextYFin(String _inicio, String _fin) throws Throwable {
        op.searchOptionsSeven(_inicio,_fin);
    }

    @Then("^Scroll hacia abajo por coordenada teniendo punto de referencia \"([^\"]*)\"$")
    public void scrollHaciaAbajoPorCoordenadaTeniendoPuntoDeReferencia(String _referencia) throws Throwable {
        op.searchOptionsEight(_referencia);
    }

    @Then("^Metodos para identificar elements$")
    public void metodosParaIdentificarElements() {
        op.searchOptionsNine();
    }

    @Then("^Drag & Drop en elemento \"([^\"]*)\"$")
    public void dragDropEnElemento(String _value) throws Throwable {
        op.searchOptionsTen(_value);
    }

    @Then("^Slider en elemento \"([^\"]*)\"$")
    public void sliderEnElemento(String _value) throws Throwable {
        op.searchOptionsEleven(_value);
    }

}
