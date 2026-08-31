package application.domain.valueobjects;

public final class CartStatus extends DomainCatalog {

    private CartStatus(String code, String name, String description) {
        super(code, name, description);
    }
}