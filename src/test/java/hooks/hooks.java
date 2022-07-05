package hooks;

import basePackage.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class hooks {
@Before
    public void setup(Scenario sc){
    BaseTest.setApiRequest(sc);
}

@After
    public void tearDown(){
    BaseTest.TearDown();
}
}
