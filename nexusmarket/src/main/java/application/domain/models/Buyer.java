package application.domain.models;

import application.domain.valueobjects.Address;
import application.domain.valueobjects.CommercialStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Buyer {

    private User user;
    private Address primaryAddress;
    private List<Address> additionalAddresses;
    private CommercialStatus commercialStatus;
}