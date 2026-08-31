package application.domain.valueobjects;

public final class CommercialStatus extends DomainCatalog {

    private CommercialStatus(String code, String name, String description) {
        super(code, name, description);
    }
}