package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(10000 * 10 / 100);

    }

    @Test
    @DisplayName("Vip가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}