package application.domain.valueobjects;

public final class ProductType extends DomainCatalog {

    public static final ProductType PHYSICAL =
            new ProductType(
                    "PHYSICAL",
                    "Physical",
                    "Product that requires inventory and shipping."
            );

    public static final ProductType DIGITAL =
            new ProductType(
                    "DIGITAL",
                    "Digital",
                    "Product delivered after payment confirmation."
            );

    private ProductType(String code, String name, String description) {
        super(code, name, description);
    }
}