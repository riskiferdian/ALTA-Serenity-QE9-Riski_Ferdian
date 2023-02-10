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
    @Step("Get list users")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list users")
    public void getInvalidListUser(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }


    @Step("post user")
    public void setPostCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Register user")
    public void setPostRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single user")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("User login")
    public void setPostLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
