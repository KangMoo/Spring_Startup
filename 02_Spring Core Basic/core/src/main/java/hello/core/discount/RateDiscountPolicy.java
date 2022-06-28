package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

/**
 * @author kangmoo Heo
 */
@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercet = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * discountPercet / 100 : 0;
    }
}
