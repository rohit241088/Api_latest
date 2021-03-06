package stepDefinitions;
import basePackage.BaseTest;
import baseRequestPackage.APIRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class Login extends BaseTest {
requestPOJO.Login classObject=null;
    @Given("User wants to call the Login API")
    public void user_wants_to_call_the_login_api() {
        // Write code here that turns the phrase above into concrete actions
      classObject=apiRequest.setupAPIRequest(requestPOJO.Login.class);
    }
    @When("email is {string}")
    public void email_is(String string) {
        // Write code here that turns the phrase above into concrete actions
       classObject.setEmail(string);
       requestPOJO.Login.setEmailValue(string);
    }
    @When("password is {string}")
    public void password_is(String string) {
        // Write code here that turns the phrase above into concrete actions
     classObject.setPassword(string);
     requestPOJO.Login.setPasswordValue(string);

    }
    @Then("login response should be {string}")
    public void login_response_should_be(String string) {

        APIRequest.requestSpecification.when().body(requestPOJO.Login.requestString).log().all().post((String) APIRequest.configProperties.get("Login")).then().log().all().statusCode(200);
        requestPOJO.Login.requestString="{\n" +
                "    \"email\": \"emailplaceholder\",\n" +
                "    \"password\": \"passwordPlaceholder\"\n" +
                "}";
    }




}
