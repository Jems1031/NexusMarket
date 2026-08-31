package application.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Address {

    private final String street;
    private final String number;
    private final String complement;
    private final String city;
    private final String department;
    private final String postalCode;

    public Address(
            String street,
            String number,
            String complement,
            String city,
            String department,
            String postalCode
    ) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.department = department;
        this.postalCode = postalCode;
    }
}