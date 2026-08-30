package application.domain.valueobjects;

public final class ProductStatus extends DomainCatalog {

    public static final ProductStatus PUBLISHED =
            new ProductStatus(
                    "PUBLISHED",
                    "Published",
                    "Product is visible and available in the catalog."
            );

    public static final ProductStatus SUSPENDED =
            new ProductStatus(
                    "SUSPENDED",
                    "Suspended",
                    "Product is temporarily unavailable for sale."
            );

    public static final ProductStatus DISCONTINUED =
            new ProductStatus(
                    "DISCONTINUED",
                    "Discontinued",
                    "Product is no longer sold."
            );

    private ProductStatus(String code, String name, String description) {
        super(code, name, description);
    }
}