package au.com.telstra.simcardactivator.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sim_card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SimCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String iccid;

    private String customerEmail;

    private boolean active;
}
