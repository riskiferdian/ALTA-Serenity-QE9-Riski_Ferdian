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

public class UpdateUser {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQUEST+"/CreateUser.json");
        reqresAPI.setPutUpdateUser(id,jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
