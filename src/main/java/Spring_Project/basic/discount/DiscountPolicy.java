package Spring_Project.basic.discount;

import Spring_Project.basic.member.Member;

public interface DiscountPolicy {

    /*
    @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
