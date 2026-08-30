package application.domain.valueobjects;

public final class UserRole extends DomainCatalog {

    public static final UserRole BUYER =
            new UserRole("BUYER", "Buyer", "Person who purchases published products.");

    public static final UserRole SELLER =
            new UserRole("SELLER", "Seller", "Person responsible for registering and managing products.");

    public static final UserRole LOGISTICS_OPERATOR =
            new UserRole(
                    "LOGISTICS_OPERATOR",
                    "Logistics Operator",
                    "Person responsible for warehouse and dispatch operations."
            );

    public static final UserRole ADMINISTRATOR =
            new UserRole(
                    "ADMINISTRATOR",
                    "Administrator",
                    "Person responsible for managing sellers and warehouses."
            );

    public static final UserRole SUPERVISOR =
            new UserRole(
                    "SUPERVISOR",
                    "Supervisor",
                    "Person responsible for operational monitoring."
            );

    private UserRole(String code, String name, String description) {
        super(code, name, description);
    }
}