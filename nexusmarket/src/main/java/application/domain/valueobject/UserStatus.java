package application.domain.valueobjects;

public final class UserStatus extends DomainCatalog {

    public static final UserStatus ACTIVE =
            new UserStatus(
                    "ACTIVE",
                    "Active",
                    "User is enabled to perform operations in NexusMarket."
            );

    public static final UserStatus BLOCKED =
            new UserStatus(
                    "BLOCKED",
                    "Blocked",
                    "User is restricted from performing operations."
            );

    private UserStatus(String code, String name, String description) {
        super(code, name, description);
    }

    public boolean canPerformOperations() {
        return this.equals(ACTIVE);
    }
}