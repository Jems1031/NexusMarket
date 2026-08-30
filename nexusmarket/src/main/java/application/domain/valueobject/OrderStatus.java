package application.domain.valueobjects;

public final class OrderStatus extends DomainCatalog {

    public static final OrderStatus SHOPPING_CART =
            new OrderStatus(
                    "SHOPPING_CART",
                    "Shopping Cart",
                    "Products selected provisionally by the buyer."
            );

    public static final OrderStatus PENDING_PAYMENT =
            new OrderStatus(
                    "PENDING_PAYMENT",
                    "Pending Payment",
                    "Order is waiting for payment confirmation."
            );

    public static final OrderStatus PAID =
            new OrderStatus(
                    "PAID",
                    "Paid",
                    "Payment has been confirmed."
            );

    public static final OrderStatus DISPATCHED =
            new OrderStatus(
                    "DISPATCHED",
                    "Dispatched",
                    "Order has left the warehouse."
            );

    public static final OrderStatus DELIVERED_COMPLETED =
            new OrderStatus(
                    "DELIVERED_COMPLETED",
                    "Delivered / Completed",
                    "Delivery was confirmed and the order was completed."
            );

    private OrderStatus(String code, String name, String description) {
        super(code, name, description);
    }
}