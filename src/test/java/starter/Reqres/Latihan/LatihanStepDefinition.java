package starter.Reqres.Latihan;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LatihanStepDefinition {
    @Steps
    StartAPI startAPI;

    // Scenario 1
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPagePage(int page) {
        startAPI.setGetListUser(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(StartAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responBodyPageShouldBePage(int page) {
        SerenityRest.then()
                .body("page", equalTo(page));
    }

    // Scenario 2
    @Given("Post create new user with valid json")
    public void postCreateNewUserWithValidJson() {
        File jsonKeb = new File(StartAPI.DIR+"/src/test/resources/JSON/ReqBody/UserReqBody.json");
        startAPI.setPostCreateUser(jsonKeb);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(StartAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    //Scenario 3
    @Given("Update user with valid id {int} json")
    public void updateUserWithValidJson(int  id) {
        File jsonKeb = new File(StartAPI.DIR+"/src/test/resources/JSON/ReqBody/UpdateUserBody.json");
        startAPI.setPutUpdateUser(id,jsonKeb);
    }

    @When("Send update user")
    public void sendUpdateUser() {
        SerenityRest.when().put(startAPI.PUT_UPDATE_USER);
    }

    //Scenario 4
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        startAPI.setDeleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeletUser() {
        SerenityRest.when().delete(StartAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int status) {
        SerenityRest.then().statusCode(status);
    }

}
