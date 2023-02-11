package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;

import java.io.File;

public class ListResource {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list resource")
    public void getListResource() {
        reqresAPI.setListResource();
    }

    @When("Send list resource")
    public void sendListResource() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }

    @And("Validate list resource json schema")
    public void validateListResourceJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Resource/ListResource.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
