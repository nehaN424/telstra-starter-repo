package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.entity.SimCard;
import au.com.telstra.simcardactivator.exception.SimCardNotFoundException;
import au.com.telstra.simcardactivator.model.SimCardResponse;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class SimCardController {

    private SimCardRepository simCardRepository;

    @GetMapping("/sim-card/{id}")
    public SimCardResponse getSimCardById(@PathVariable Long id) {

        Optional<SimCard> optional = simCardRepository.findById(id);
        if (!optional.isPresent()) {
            throw new SimCardNotFoundException("No Sim Card found for id " + id);
        }
        return optional.map(SimCardResponse::new).get();
    }
}
