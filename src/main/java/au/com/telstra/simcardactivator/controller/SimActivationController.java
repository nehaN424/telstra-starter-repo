package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.model.SimActivationResponse;
import au.com.telstra.simcardactivator.service.SimActivationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class SimActivationController {

    private SimActivationService simActivationService;

    @PostMapping("/activate-sim")
    public SimActivationResponse activateSim(@Valid @RequestBody SimActivationRequest simActivationRequest) {
        return simActivationService.activateSim(simActivationRequest);
    }
}