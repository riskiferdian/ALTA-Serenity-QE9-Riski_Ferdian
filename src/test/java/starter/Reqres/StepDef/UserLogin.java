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
import starter.Reqres.Utils.ReqresResponses;

import java.awt.*;
import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserLogin {
    @Steps
    ReqresAPI reqresAPI;

    // Positif Case
    @Given("User login with valid data")
    public void userLoginWithValidData() {
        File json = new File(Constant.JSON_REQUEST+"/Login/ValidData.json");
        reqresAPI.setPostLogin(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate user login json schema")
    public void validateUserLoginJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/UserLogin.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    // Negative case 1
    @Given("Send login with empty password")
    public void sendLoginWithEmptyPassword() {
        File json = new File(Constant.JSON_REQUEST+"/Login/EmptyPassword.json");
        reqresAPI.postInvalidLogin(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Response body status should be {string}")
    public void responseBodyStatusShouldBe(String status) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(status));
    }

    @And("Validate empty password json schema")
    public void validateEmptyPasswordJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/Login/InvalidLogin.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Send login with empty email")
    public void sendLoginWithEmptyEmail() {
        File json = new File(Constant.JSON_REQUEST+"/Login/EmptyEmail.json");
        reqresAPI.postInvalidLogin(json);
    }

    @And("Validate empty email json schema")
    public void validateEmptyEmailJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/InvalidLogin.json");
    }
}
