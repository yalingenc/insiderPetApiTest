package models;

import clients.BaseClient;
import clients.CrudOperations;
import io.restassured.response.Response;
import java.util.*;

public class AddNewPet {

    CrudOperations crudOperations = new CrudOperations();
    BaseClient baseClient = new BaseClient();

    Map<String,Object> jsonBody = new LinkedHashMap<String,Object>();
    Map<String,Object> category = new HashMap<String, Object>();
    List<String> photosUrls = new ArrayList<String>();
    List<Map> tagsList = new ArrayList<Map>();
    Map<String,Object> tagsMap = new HashMap<String, Object>();

    public Response createPet(){
        jsonBody.put("id", baseClient.prop.getProperty("petId"));
        category.put("id",baseClient.prop.getProperty("categoryId"));
        category.put("name",baseClient.prop.getProperty("categoryName"));
        jsonBody.put("category",category);
        photosUrls.add(baseClient.prop.getProperty("photosUrl1"));
        photosUrls.add(baseClient.prop.getProperty("photosUrl2"));
        jsonBody.put("photoUrls",photosUrls);
        tagsMap.put("id",baseClient.prop.getProperty("tagsId"));
        tagsMap.put("name",baseClient.prop.getProperty("tagsName"));
        tagsList.add(tagsMap);
        jsonBody.put("tags",tagsList);
        jsonBody.put("status",baseClient.prop.getProperty("status"));
        return crudOperations.createPet(jsonBody);
    }

    public Response createNullPetObject(){
        jsonBody.put("id", " ");
        category.put("id"," ");
        category.put("name"," ");
        jsonBody.put("category",category);
        photosUrls.add(" ");
        photosUrls.add(" ");
        jsonBody.put("photoUrls",photosUrls);
        tagsMap.put("id"," ");
        tagsMap.put("name", " ");
        tagsList.add(tagsMap);
        jsonBody.put("tags",tagsList);
        jsonBody.put("status", " ");
        return crudOperations.createPet(jsonBody);
    }

    public Response createPetWithInvalidVariables(){
        jsonBody.put("invalidPetId", baseClient.prop.getProperty("petId"));
        category.put("invalidCategoryId",baseClient.prop.getProperty("categoryId"));
        category.put("name",baseClient.prop.getProperty("categoryName"));
        jsonBody.put("category",category);
        photosUrls.add(baseClient.prop.getProperty("photosUrl1"));
        photosUrls.add(baseClient.prop.getProperty("photosUrl2"));
        jsonBody.put("photoUrls",photosUrls);
        tagsMap.put("id",baseClient.prop.getProperty("tagsId"));
        tagsMap.put("name",baseClient.prop.getProperty("tagsName"));
        tagsList.add(tagsMap);
        jsonBody.put("tags",tagsList);
        jsonBody.put("status",baseClient.prop.getProperty("status"));
        return crudOperations.createPet(jsonBody);
    }

}
