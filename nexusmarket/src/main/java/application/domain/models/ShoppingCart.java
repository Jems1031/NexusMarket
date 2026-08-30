package application.domain.models;

import application.domain.valueobjects.CartStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart {

    private String id;
    private Buyer buyer;
    private List<CartItem> items;
    private CartStatus status;
}