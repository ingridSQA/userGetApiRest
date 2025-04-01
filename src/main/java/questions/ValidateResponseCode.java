package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ValidateResponseCode implements Question<Boolean> {
    private final int statusCode;
    public ValidateResponseCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public static ValidateResponseCode is(int statusCode){
        return new ValidateResponseCode(statusCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).getStatusCode() == statusCode;
    }
}
