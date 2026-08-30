package application.domain.models;

import application.domain.valueobjects.Address;
import application.domain.valueobjects.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    private String id;
    private Buyer buyer;
    private List<OrderItem> items;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private Address deliveryAddress;
    private BigDecimal total;
}