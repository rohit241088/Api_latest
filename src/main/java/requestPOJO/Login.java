package requestPOJO;

import baseRequestPackage.APIRequest;


public class Login extends BasePOJO {
    private String email;
    private String password;


        public void setEmail(String email){
        this.email=email;
           }
    public void setPassword(String password){
        this.password=password;
           }


}
