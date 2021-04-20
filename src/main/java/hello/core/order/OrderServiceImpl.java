package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*@Autowired // @RequiredArgsConstructor 으로 제거 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Optional<Member> member = memberRepository.findById(memberId);
//        int discountPrice = discountPolicy.discount(member, itemPrice);
        int discountPrice = 0;

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도(인터페이스 오버라이드X)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
