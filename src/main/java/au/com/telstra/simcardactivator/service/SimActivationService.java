package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.entity.SimCard;
import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.model.SimActivationResponse;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class SimActivationService {

    private static final String SIM_ACTIVATOR_URL = "http://localhost:8444/actuate";

    private RestTemplate restTemplate;

    private SimCardRepository simCardRepository;

    public SimActivationResponse activateSim(SimActivationRequest simActivationRequest) {

        ResponseEntity<SimActivationResponse> responseEntity =
                restTemplate.postForEntity(SIM_ACTIVATOR_URL, simActivationRequest, SimActivationResponse.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            SimCard simCard = SimCard.builder()
                    .iccid(simActivationRequest.getIccid())
                    .customerEmail(simActivationRequest.getCustomerEmail())
                    .active(true)
                    .build();
            simCardRepository.save(simCard);
        }

        return responseEntity.getBody();
    }
}
