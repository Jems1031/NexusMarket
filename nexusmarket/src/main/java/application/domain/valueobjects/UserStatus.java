package application.domain.valueobjects;

public final class UserStatus extends DomainCatalog {

    public static final UserStatus ACTIVE =
            new UserStatus("ACTIVE", "Active", "User is enabled to operate.");

    public static final UserStatus BLOCKED =
            new UserStatus("BLOCKED", "Blocked", "User is restricted from operating.");

    private UserStatus(String code, String name, String description) {
        super(code, name, description);
    }
}