import clients.BaseClient;
import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestCases {

    public Response response;
    GetPet getPet;
    AddNewPet addNewPet;
    BaseClient baseClient;
    UpdatePet updatePet;
    DeletePet deletePet;

    @BeforeSuite
    public void setUp(){
        getPet = new GetPet();
        addNewPet = new AddNewPet();
        baseClient = new BaseClient();
        updatePet = new UpdatePet();
        deletePet = new DeletePet();
    }

    @Test(priority = 1)
    public void createPetTest(){
        response = addNewPet.createPet();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(baseClient.prop.getProperty("petId"),response.jsonPath().get("id").toString());
        Assert.assertEquals(baseClient.prop.getProperty("categoryId"),response.jsonPath().get("category.id").toString());
        Assert.assertEquals(baseClient.prop.getProperty("categoryName"),response.jsonPath().get("category.name").toString());
        Assert.assertEquals(baseClient.prop.getProperty("status"),response.jsonPath().get("status").toString());
    }

    @Test(priority = 2)
    public void createPetWithNullParametersTest(){
        response = addNewPet.createNullPetObject();
        Assert.assertEquals(response.getStatusCode(),405);
    }

    @Test(priority = 3)
    public void createPetWithInvalidParameterTest(){
        response = addNewPet.createPetWithInvalidVariables();
        Assert.assertEquals(response.getStatusCode(),405);
    }

    @Test(priority = 4)
    public void getPetWithIdTest(){
        Response response = getPet.getResponseForPet();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(baseClient.prop.getProperty("petId"),response.jsonPath().getString("id"));
        Assert.assertEquals(baseClient.prop.getProperty("categoryId"),response.jsonPath().get("category.id").toString());
        Assert.assertEquals(baseClient.prop.getProperty("categoryName"),response.jsonPath().get("category.name").toString());
        Assert.assertEquals(baseClient.prop.getProperty("status"),response.jsonPath().get("status").toString());
    }

    @Test(priority = 5)
    public void getPetWithInvalidIdTest(){
        Response response = getPet.getInvalidResponseForPet();
        Assert.assertEquals(response.getStatusCode(),400);
    }

    @Test(priority = 6)
    public void getPetWithNotCreatedIdTest(){
        Response response = getPet.getNotCreatedIdResponseForPet();
        Assert.assertEquals(response.getStatusCode(),404);
    }


    @Test(priority = 7)
    public void updatePetTest(){
        response = updatePet.updatePet();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(baseClient.prop.getProperty("petId"),response.jsonPath().get("id").toString());
        Assert.assertEquals(baseClient.prop.getProperty("updatedCategoryId"),response.jsonPath().get("category.id").toString());
        Assert.assertEquals(baseClient.prop.getProperty("updatedCategoryName"),response.jsonPath().get("category.name").toString());
        Assert.assertEquals(baseClient.prop.getProperty("updatedStatus"),response.jsonPath().get("status").toString());
    }


    @Test(priority = 8)
    public void updatePetInvalidIdTest(){
        response = updatePet.updatePetWithInvalidId();
        Assert.assertEquals(response.getStatusCode(),400);
    }

    @Test(priority = 9)
    public void updatePetNotFoundTest(){
        response = updatePet.updatePetWithInvalidId();
        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Test(priority = 10)
    public void deletePetWithIdTest(){
        Response response = deletePet.getResponseForDeletePet();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 11)
    public void deletePetWithInvalidIdTest(){
        Response response = deletePet.getInvalidResponseForDeletePet();
        Assert.assertEquals(response.getStatusCode(),400);
    }

    @Test(priority = 12)
    public void deletePetWithNotCreatedIdTest(){
        Response response = deletePet.getInvalidResponseForDeletePet();
        Assert.assertEquals(response.getStatusCode(),404);
    }

}
