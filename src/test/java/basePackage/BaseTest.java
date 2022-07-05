package basePackage;

import baseRequestPackage.APIRequest;
import io.cucumber.java.Scenario;


public class BaseTest {

    public static APIRequest apiRequest;
    public static Scenario scenario;
    public static void setApiRequest(Scenario sc){
        BaseTest.scenario=sc;
apiRequest=new APIRequest(true) ;

   }

   public static void TearDown(){
        APIRequest.requestSpecification=null;
   }

   public static<T extends APIRequest> void callAPI(Class<T>clas){

   }
}
