package hello.core.order;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kangmoo Heo
 */
@AllArgsConstructor
@Data
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }
}
