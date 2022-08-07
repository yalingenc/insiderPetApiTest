package models;

import clients.BaseClient;
import clients.CrudOperations;
import io.restassured.response.Response;

public class DeletePet {

    BaseClient baseClient = new BaseClient();
    CrudOperations crudOperations = new CrudOperations();

    public Response getResponseForDeletePet()
    {
        return crudOperations.deletePet(baseClient.prop.getProperty("petId"));
    }

    public Response getInvalidResponseForDeletePet()
    {
        return crudOperations.deletePet(baseClient.prop.getProperty("notCreatedId"));
    }

}
