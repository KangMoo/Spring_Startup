package hello.core.discount;

import hello.core.member.Member;

/**
 * @author kangmoo Heo
 */
public interface DiscountPolicy {
    int discount(Member member, int price);
}
