package StepDefinition;

import Core.APiCall;
import Core.FileHandleHelper;
import Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import repository.remoteRepo.requestRepo.EmpRegPostRequestModel;
import repository.remoteRepo.responsRepo.EmpRegPostResponseModel;

import static Core.CoreConstrainHelper.base_url;
import static Core.FilePathHelper.postApiPath;

public class EmpRegPostAPiStepdefs {
    private Gson gson = new Gson();

    private String requestModel;
    Response postAPiResponse;

    EmpRegPostRequestModel empRegPostRequestModel;

    String url;
    @Given("register has the api  {string}")
    public void registerHasTheApiPath(String path) {
        url = base_url +path;
        
    }

    @When("register hit {string} and {string}")
    public void registerHitEmailAndPassword(String email, String password) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(postApiPath);
        empRegPostRequestModel = new Gson().fromJson(requestBody.toJSONString(), EmpRegPostRequestModel.class);
        empRegPostRequestModel.setEmail(email);
        empRegPostRequestModel.setPassword(password);
        requestModel = gson.toJson(empRegPostRequestModel);


    }

    @And("call the api with body")
    public void callTheApiWithBody() {
        postAPiResponse = APiCall.postCall(HeaderFormatHelper.commonHeaders(),requestModel,url);
        System.out.println(postAPiResponse.body().asString());
        
    }

    @Then("it will return token")
    public void itWillReturnToken() {
        EmpRegPostResponseModel empRegPostResponseModel = gson.fromJson(postAPiResponse.getBody().asString(), EmpRegPostResponseModel.class);
        System.out.println(empRegPostResponseModel.getId());
        System.out.println(empRegPostResponseModel.getToken());
    }
}

