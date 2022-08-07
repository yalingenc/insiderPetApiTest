package clients;

import constants.ApiConstants;
import io.restassured.response.Response;
import org.apache.http.client.methods.HttpGet;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CrudOperations extends BaseClient {

    public CrudOperations(){
        super();
    }

    public Response response;

    public Response getPet(String id){
        response =
                given(requestSpecification)
                        .when()
                        .get(ApiConstants.GetPet_URl, id)
                        .then()
                        .extract().response();
        return response;
    }

    public Response createPet(Map jsonObject){
        response =
                given(requestSpecification)
                        .body(jsonObject)
                        .when()
                        .post(ApiConstants.PostPet_URl)
                        .then()
                        .extract().response();
        return response;
    }

    public Response updatePet(Map jsonObject){
        response =
                given(requestSpecification)
                        .body(jsonObject)
                        .when()
                        .put(ApiConstants.UpdatePet_URl)
                        .then()
                        .extract().response();
        return response;
    }

    public Response deletePet(String id){
        response =
                given(requestSpecification)
                        .when()
                        .delete(ApiConstants.DeletePet_URl,id)
                        .then()
                        .extract().response();
        return response;
    }


}
