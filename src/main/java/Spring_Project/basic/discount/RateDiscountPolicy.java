package Spring_Project.basic.discount;

import Spring_Project.basic.member.Grade;
import Spring_Project.basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;   // 10% 할인 로직이 매우 어려움 -> 로직 설계를 잘 해야됨
        } else {
            return 0;
        }
    }
}
