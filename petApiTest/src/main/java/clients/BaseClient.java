package clients;

import constants.ApiConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.omg.IOP.Encoding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClient {

    public RequestSpecification requestSpecification;
    public Properties prop;

    public BaseClient(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(ApiConstants.Base_URl)
                .setContentType("application/json")
                .setUrlEncodingEnabled(true)
                .build();

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/config/config.properties");
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
