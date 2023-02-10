package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUser {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyShouldBe(int page){
        SerenityRest.then().body("page", equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA +"/ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    //negative case
    @Given("Get list parameter with invalid page {string}")
    public void getListParameterWithInvalidPage(String page) {
        reqresAPI.getInvalidListUser(page);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodShouldBe(int code) {
        SerenityRest.then().statusCode(code);
    }

}
