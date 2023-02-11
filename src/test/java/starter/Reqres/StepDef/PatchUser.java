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

public class PatchUser {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch user with valid id {int}")
    public void patchUserWithValiId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Patch/PatchUser.json");
        reqresAPI.patchUser(id,json);
    }

    @When("Send request patch user")
    public void sendRequestPatchUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_USER);
    }

    @And("Validate patch user json schema")
    public void validatePatchUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Patch/PatchUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case 1
    @Given("Patch user with invalid id {string} and valid json")
    public void patchUserWithInvalidId(String id) {
        File json = new File(Constant.JSON_REQUEST+"/Patch/PatchUser.json");
        reqresAPI.invalidPatchUser(id,json);
    }

    //Negative Case 2
    @Given("Patch user with invalid json and valid id {int}")
    public void patchUserWithInvalidJsonAndValidId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Patch/InvalidPatch.json");
        reqresAPI.patchUser(id,json);
    }
}
