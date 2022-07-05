package baseRequestPackage;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import requestPOJO.BasePOJO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.*;

public  class APIRequest {
public static Map<String,Properties> map=null;
public static RequestSpecification requestSpecification=null;
public static Properties configProperties=null;
private Boolean bool=false;
public APIRequest(boolean readConfiguration){
    this.bool=readConfiguration;
         if(configProperties==null){
         try {
             configProperties=new Properties();
             FileInputStream in=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//config//config.properties");
             configProperties.load(in);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
    requestSpecification= RestAssured.given().baseUri(configProperties.get("baseURI").toString());
     if(readConfiguration&&map==null){
        FileInputStream in;
        map=new HashMap<>();
        try {
          File files=new File(System.getProperty("user.dir")+"//src//main//resources");
          File[] fileArray=files.listFiles();
          for(File e:fileArray){
              try {
                  Properties properties=new Properties();
                  in=new FileInputStream(e);
                  properties.load(in);
String fileName=e.getName().split("\\.")[0];
                  map.put(fileName,properties);
                 }
              catch (FileNotFoundException ex) {
                  throw new RuntimeException(ex);
              } catch (IOException ex) {
                  throw new RuntimeException(ex);
              }
          }
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }

    }

    }
    public <T extends BasePOJO> T setupAPIRequest(Class<T>cls){
    if(APIRequest.map!=null) {
        Properties properties= map.get(cls.getSimpleName());
        Iterator<Object> propertiesIterator=properties.keySet().iterator();
        while(propertiesIterator.hasNext())
        {
            String p=propertiesIterator.next().toString();
            String property=p.split("@@@")[0];
            String propertyType=p.split("@@@")[1];
            requestSpecification.header(property,properties.getProperty(p));
        }
        }
        try {
            return cls.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public  <T extends APIRequest>Properties getProperties(Class<T> cls){
       return map.get(cls.getCanonicalName());
    }



}
