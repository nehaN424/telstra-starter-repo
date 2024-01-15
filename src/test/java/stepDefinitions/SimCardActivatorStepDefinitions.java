package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.model.SimActivationResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<SimActivationResponse> responseEntity;
    public static String SIM_ACTIVATION_URL = "http://localhost:8080/activate-sim";

    @When("the client calls activate-sim api with iccid-1255789453849037777")
    public void the_client_calls_activate_sim_api_with_success_iccid() throws Throwable {
        SimActivationRequest request = new SimActivationRequest();
        request.setIccid("1255789453849037777");
        request.setCustomerEmail("customerEmail");
        responseEntity = restTemplate.postForEntity(SIM_ACTIVATION_URL, request, SimActivationResponse.class);
    }

    @Then("the client receives success value as true")
    public void the_client_receives_success_value_as_true() throws Throwable {
        assertEquals("true", responseEntity.getBody().getSuccess());
    }

    @When("the client calls activate-sim api with iccid-8944500102198304826")
    public void the_client_calls_activate_sim_api_with_failure_iccid() throws Throwable {
        SimActivationRequest request = new SimActivationRequest();
        request.setIccid("8944500102198304826");
        request.setCustomerEmail("customerEmail");
        responseEntity = restTemplate.postForEntity(SIM_ACTIVATION_URL, request, SimActivationResponse.class);
    }

    @Then("the client receives success value as false")
    public void the_client_receives_status_value_as_false() throws Throwable {
        assertEquals("false", responseEntity.getBody().getSuccess());
    }

}