package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;

import java.io.File;

public class ListSingleResource {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list single resource {int}")
    public void getListSingleResource(int id) {
        reqresAPI.listSingleResource(id);
    }

    @When("Send request single resource")
    public void sendRequestSingleResource() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE_SINGLE);
    }

    @And("Validate list single resource")
    public void validateListSingleResource() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Resource/ListSingleResource.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list single resource {string}")
    public void getListSingleResource(String id) {
        reqresAPI.invalidListSingleResource(id);
    }
}
