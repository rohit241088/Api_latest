package requestPOJO;

import baseRequestPackage.APIRequest;


public class Login extends BasePOJO {
    public static String requestString="{\n" +
            "    \"email\": \"emailplaceholder\",\n" +
            "    \"password\": \"passwordPlaceholder\"\n" +
            "}";
    private String email;
    private String password;


        public void setEmail(String email){
        this.email=email;
           }
    public void setPassword(String password){
        this.password=password;
           }
public String getEmail(){
            return email;
}

public String getPassword(){
            return password;
}

public static void setEmailValue(String email){
         requestString=requestString.replace("emailplaceholder",email);
}
    public static void setPasswordValue(String password){
        requestString=requestString.replace("passwordPlaceholder",password);
    }

    }
