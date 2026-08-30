package application.domain.valueobjects;

public final class WarehouseType extends DomainCatalog {

    public static final WarehouseType MARKETPLACE =
            new WarehouseType(
                    "MARKETPLACE",
                    "Marketplace Warehouse",
                    "Physical storage space managed by NexusMarket."
            );

    public static final WarehouseType SELLER =
            new WarehouseType(
                    "SELLER",
                    "Seller Warehouse",
                    "Physical storage space associated with a seller."
            );

    private WarehouseType(String code, String name, String description) {
        super(code, name, description);
    }
}