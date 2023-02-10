package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserLogin {
    @Steps
    ReqresAPI reqresAPI;
    @Given("User login with valid data")
    public void userLoginWithValidData() {
        File json = new File(Constant.JSON_REQUEST+"/UserLogin.json");
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
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UserLogin.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
