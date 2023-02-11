package starter.Reqres;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Reqres.Utils.Constant;
import javax.swing.*;
import java.io.DataInput;
import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static  String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_REGISTER_USER = Constant.BASE_URL+"/api/register";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_LOGIN = Constant.BASE_URL+"/api/login";
    public static String LIST_RESOURCE = Constant.BASE_URL+"/api/unknown";
    public static String LIST_RESOURCE_SINGLE = Constant.BASE_URL+"/api/unknown/{id}";
    public static String PATCH_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELAY_USER = Constant.BASE_URL+"/api/users?delay={delay}";

    // GET LIST
    @Step("Get list users")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Get invalid list users")
    public void getInvalidListUser(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    //GET SINGLE
    @Step("Get single user")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    //GET LIST RESOURCE
    @Step("Get list resource")
    public void setListResource(){
        SerenityRest.given();
    }

    //GET SINGLE RESOURCE
    @Step("Get list single resource")
    public void listSingleResource(int id){
        SerenityRest.given().pathParam("id",id);
    }

    //GET SINGLE RESOURCE INVALID ID
    @Step("Get list single resource invalid id")
    public void invalidListSingleResource(String id){
        SerenityRest.given().pathParam("id",id);
    }

    //GET DELAYED RESPONSE
    @Step("Get delayed response")
    public void getDelayed(int delay){
        SerenityRest.given().pathParam("delay",delay);
    }

    // POST CREATE
    @Step("post create user")
    public void setPostCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("invalid post create user")
    public void postInvalidCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //POST REGISTER
    @Step("post register user")
    public void setPostRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("post invalid register user")
    public void invalidPostRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // POST LOGIN
    @Step("User login")
    public void setPostLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("User invalid login")
    public void postInvalidLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //PUT UPDATE
    @Step("put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    // INVALID UPDATE
    @Step("invalid update user")
    public void invalidPutUpdateUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //DELETE USER
    @Step("delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("invalid delete user")
    public void invalidDeleteUser(String id){
        SerenityRest.given().pathParam("id",id);
    }

    //PATCH USER
    @Step("patch user")
    public void patchUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("patch user")
    public void invalidPatchUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
