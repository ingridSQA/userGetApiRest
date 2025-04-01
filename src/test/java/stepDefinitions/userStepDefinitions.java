package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ValidateResponseCode;
import task.GetRequestTask;

import static org.assertj.core.api.Assertions.assertThat;

public class userStepDefinitions {

    private static final String API_URL = "https://reqres.in";

    private final Actor actor = Actor.named("Ingrid");

    @Before
    public void setUp() {
        actor.can(CallAnApi.at(API_URL));
    }

    @Given("que el usuario realiza una peticion GET a {string}")
    public void queElUsuarioRealizaUnaPeticionGETA(String endpoint) {
        actor.attemptsTo(GetRequestTask.getRequestTask(endpoint));
    }

    @Then("la respuesta debe tener un codigo con estado {int}")
    public void laRespuestaDebeTenerUnCodigoConEstado(Integer statusCode) {
        assertThat(actor.asksFor(ValidateResponseCode.is(statusCode))).isTrue();
    }
}
