package hello.core.order;

/**
 * @author kangmoo Heo
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
