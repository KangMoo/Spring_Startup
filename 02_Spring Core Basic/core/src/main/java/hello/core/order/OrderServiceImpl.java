package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * @author kangmoo Heo
 */
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    /*
    // Not recommended using Auto inject by Field Injection
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;
    */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*
    // Replaced by lombok annotation (RequiredArgsConstructor)
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("Dependency auto injected by Constructor");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    /*
    // Not recommended using Auto inject by Setter
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
    }*/

    /*
    // Not recommended using Auto Method Injection
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("Dependency Injection By Normal Method Injection");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

}
