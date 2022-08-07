package models;

import clients.BaseClient;
import clients.CrudOperations;
import io.restassured.response.Response;

import java.util.*;

public class UpdatePet {

    CrudOperations crudOperations = new CrudOperations();
    BaseClient baseClient = new BaseClient();

    Map<String,Object> jsonBody = new LinkedHashMap<String,Object>();
    Map<String,Object> category = new HashMap<String, Object>();
    List<String> photosUrls = new ArrayList<String>();
    List<Map> tagsList = new ArrayList<Map>();
    Map<String,Object> tagsMap = new HashMap<String, Object>();

    public Response updatePet(){
        jsonBody.put("id", baseClient.prop.getProperty("petId"));
        category.put("id",baseClient.prop.getProperty("updatedCategoryId"));
        category.put("name",baseClient.prop.getProperty("updatedCategoryName"));
        jsonBody.put("category",category);
        photosUrls.add(baseClient.prop.getProperty("photosUrl1"));
        photosUrls.add(baseClient.prop.getProperty("photosUrl2"));
        jsonBody.put("photoUrls",photosUrls);
        tagsMap.put("id",baseClient.prop.getProperty("tagsId"));
        tagsMap.put("name",baseClient.prop.getProperty("tagsName"));
        tagsList.add(tagsMap);
        jsonBody.put("tags",tagsList);
        jsonBody.put("status",baseClient.prop.getProperty("updatedStatus"));
        return crudOperations.createPet(jsonBody);
    }

    public Response updatePetWithInvalidId(){
        jsonBody.put("id", baseClient.prop.getProperty("invalidPetId"));
        category.put("id",baseClient.prop.getProperty("updatedCategoryId"));
        category.put("name",baseClient.prop.getProperty("updatedCategoryName"));
        jsonBody.put("category",category);
        photosUrls.add(baseClient.prop.getProperty("photosUrl1"));
        photosUrls.add(baseClient.prop.getProperty("photosUrl2"));
        jsonBody.put("photoUrls",photosUrls);
        tagsMap.put("id",baseClient.prop.getProperty("tagsId"));
        tagsMap.put("name",baseClient.prop.getProperty("tagsName"));
        tagsList.add(tagsMap);
        jsonBody.put("tags",tagsList);
        jsonBody.put("status",baseClient.prop.getProperty("updatedStatus"));
        return crudOperations.createPet(jsonBody);
    }



}
