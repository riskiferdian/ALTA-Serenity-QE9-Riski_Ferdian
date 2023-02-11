package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Feature;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUser {
    @Steps
    ReqresAPI reqresAPI;

    //Positif case
    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQUEST+"/Register/RegisterUser.json");
        reqresAPI.setPostRegisterUser(jsonReq);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyIdShouldBeAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body("token",equalTo(token));
    }

    @And("Validate register user json schema")
    public void validateRegisterUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Register/RegisterUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negatif case 1
    @Given("User register with empty password")
    public void userRegisterWithEmptyPassword() {
        File json = new File(Constant.JSON_REQUEST+"/Register/EmptyPassword.json");
        reqresAPI.invalidPostRegisterUser(json);
    }

    @And("Validate register empty password json schema")
    public void validateRegisterEmptyPasswordJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Register/InvalidRegister.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negatif case 2
    @Given("User register with empty email")
    public void userRegisterWithEmptyEmail() {
        File json = new File(Constant.JSON_REQUEST+"/Register/EmptyEmail.json");
        reqresAPI.invalidPostRegisterUser(json);
    }

    @And("Validate register empty email json schema")
    public void validateRegisterEmptyEmailJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Register/InvalidRegister.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
