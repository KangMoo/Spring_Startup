package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kangmoo Heo
 */
@Component
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("Dependency auto injected by Constructor");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    @Autowired
    public OrderServiceImpl setMemberRepository(MemberRepository memberRepository) {
        System.out.println("MemberRepository Dependency auto injected by Setter");
        this.memberRepository = memberRepository;
        return this;
    }

    @Autowired
    public OrderServiceImpl setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("DiscountPolicy Dependency auto injected by Setter");
        this.discountPolicy = discountPolicy;
        return this;
    }
}
