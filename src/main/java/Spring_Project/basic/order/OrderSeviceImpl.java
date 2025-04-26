package Spring_Project.basic.order;

import Spring_Project.basic.discount.DiscountPolicy;
import Spring_Project.basic.discount.FixDiscountPolicy;
import Spring_Project.basic.member.Member;
import Spring_Project.basic.member.MemberRepository;
import Spring_Project.basic.member.MemoryMemberRepository;

public class OrderSeviceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
