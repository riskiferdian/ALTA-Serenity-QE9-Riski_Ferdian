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
        File jsonReq = new File(Constant.JSON_REQUEST+"/Update/UpdateUser.json");
        reqresAPI.setPutUpdateUser(id,jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Update/UpdateUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Update user with invalid parameter id {string}")
    public void updateUserWithInvalidParameterId(String id) {
        File json = new File(Constant.JSON_REQUEST+"/Update/UpdateUser.json");
        reqresAPI.invalidPutUpdateUser(id,json);
    }

    @Given("Update user with invalid file json and valid id {int}")
    public void updateUserWithInvalidFileJson(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Update/InvalidUpdate.json");
        reqresAPI.setPutUpdateUser(id,json);
    }
}
