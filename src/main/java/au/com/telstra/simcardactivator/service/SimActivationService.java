package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.model.SimActivationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class SimActivationService {

    private static final String SIM_ACTIVATOR_URL = "http://localhost:8444/actuate";

    private RestTemplate restTemplate;

    public SimActivationResponse activateSim(SimActivationRequest simActivationRequest) {
        ResponseEntity<SimActivationResponse> responseEntity =
                restTemplate.postForEntity(SIM_ACTIVATOR_URL, simActivationRequest, SimActivationResponse.class);
        return responseEntity.getBody();
    }
}
