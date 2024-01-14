package au.com.telstra.simcardactivator.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SimActivationRequest {

    @NotEmpty(message = "iccid field cannot be empty")
    private String iccid;

    @NotEmpty(message = "customer email cannot be empty")
    private String customerEmail;
}
