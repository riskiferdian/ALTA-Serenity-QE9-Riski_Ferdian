package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;

import java.io.File;

public class DelayedResponse {
    @Steps
    ReqresAPI reqresAPI;
    @Given("User get delayed response with valid data {int}")
    public void userGetDelayedResponseWithValidData(int delay) {
        reqresAPI.getDelayed(delay);
    }

    @When("Send request delayed response")
    public void sendRequestDelayedResponse() {
        SerenityRest.when().get(ReqresAPI.DELAY_USER);
    }

    @And("Validate delayed response json schema")
    public void validateDelayedResponseJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Delayed/DelayedResponse.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
