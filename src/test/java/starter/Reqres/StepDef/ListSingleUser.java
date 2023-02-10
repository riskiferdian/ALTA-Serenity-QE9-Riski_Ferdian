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

import static org.hamcrest.CoreMatchers.equalTo;

public class ListSingleUser {
    @Steps
    ReqresAPI reqresAPI;

    //valid case
    @Given("Get single user with valid {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.setGetSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.then().body("data.id",equalTo(id));
    }

    @And("Validate list single user json schema")
    public void validateListSingleUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    // invalid case
    @Given("Get single user with invalid parameter {int}")
    public void getSingleUserWithInvalidParameter(int id) {
        reqresAPI.setGetSingleUser(id);
    }
}
