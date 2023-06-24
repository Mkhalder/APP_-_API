package StepDefinition;

import Core.APiCall;
import Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import repository.remoteRepo.responsRepo.EmpRegGetResponseModel;

import static Core.CoreConstrainHelper.base_url;

public class EmpRegGetAPiStepdefs {
    String url;
    private Response responseGetAPi;
    private Gson gson = new Gson();


    @Given("user has the base api")
    public void userHasTheBaseApi() {
        url = base_url + "users";
        
    }

    @When("user call the {string} and {string}")
    public void userCallTheParameterAndParamsValue(String paraName, String value) {
        url = url + paraName + "=" + value;
        System.out.println(url);
        responseGetAPi = APiCall.getCall(HeaderFormatHelper.commonHeaders(), url);
        System.out.println(responseGetAPi.body().asString());
        
    }

    @Then("it will return valid data")
    public void itWillReturnValidData() {
        EmpRegGetResponseModel empRegGetResponseModel = gson.fromJson(responseGetAPi.getBody().asString(), EmpRegGetResponseModel.class);

        System.out.println(empRegGetResponseModel.getData().get(0).getFirst_name());

    }
}
