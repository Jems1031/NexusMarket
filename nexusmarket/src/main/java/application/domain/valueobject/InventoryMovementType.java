package application.domain.valueobjects;

public final class InventoryMovementType extends DomainCatalog {

    public static final InventoryMovementType ENTRY =
            new InventoryMovementType(
                    "ENTRY",
                    "Entry",
                    "Stock is added to inventory."
            );

    public static final InventoryMovementType RESERVATION =
            new InventoryMovementType(
                    "RESERVATION",
                    "Reservation",
                    "Stock is reserved for a commercial operation."
            );

    public static final InventoryMovementType SALE_OUTPUT =
            new InventoryMovementType(
                    "SALE_OUTPUT",
                    "Sale Output",
                    "Stock is reduced because of a sale."
            );

    public static final InventoryMovementType ADJUSTMENT =
            new InventoryMovementType(
                    "ADJUSTMENT",
                    "Adjustment",
                    "Stock is modified due to a correction."
            );

    public static final InventoryMovementType RETURN =
            new InventoryMovementType(
                    "RETURN",
                    "Return",
                    "Stock is added or adjusted because of a returned product."
            );

    private InventoryMovementType(String code, String name, String description) {
        super(code, name, description);
    }
}