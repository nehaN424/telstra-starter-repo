package au.com.telstra.simcardactivator.model;

import au.com.telstra.simcardactivator.entity.SimCard;
import lombok.Data;

@Data
public class SimCardResponse {

    private String iccid;
    private String customerEmail;
    private boolean active;

    public SimCardResponse(SimCard simCard) {
        this.iccid = simCard.getIccid();
        this.customerEmail = simCard.getCustomerEmail();
        this.active = simCard.isActive();
    }
}
