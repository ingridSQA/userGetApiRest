package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetRequestTask implements Task {
    private final String endpoint;

    public GetRequestTask(String endpoint) {
        this.endpoint = endpoint;
    }
    public static GetRequestTask getRequestTask(String endpoint){
        return instrumented(GetRequestTask.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint)
        );
    }
}
