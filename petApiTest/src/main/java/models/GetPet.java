package models;


import clients.BaseClient;
import clients.CrudOperations;
import io.restassured.response.Response;

public class GetPet {

    BaseClient baseClient = new BaseClient();
    CrudOperations crudOperations = new CrudOperations();

    public Response getResponseForPet()
    {
        return crudOperations.getPet(baseClient.prop.getProperty("petId"));
    }

    public Response getInvalidResponseForPet()
    {
        return crudOperations.getPet(baseClient.prop.getProperty("invalidPetId"));
    }

    public Response getNotCreatedIdResponseForPet()
    {
        return crudOperations.getPet(baseClient.prop.getProperty("notCreatedId"));
    }

}
