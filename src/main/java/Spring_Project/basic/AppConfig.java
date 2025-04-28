package Spring_Project.basic;

import Spring_Project.basic.discount.DiscountPolicy;
import Spring_Project.basic.discount.FixDiscountPolicy;
import Spring_Project.basic.discount.RateDiscountPolicy;
import Spring_Project.basic.member.MemberRepository;
import Spring_Project.basic.member.MemberService;
import Spring_Project.basic.member.MemberServiceImpl;
import Spring_Project.basic.member.MemoryMemberRepository;
import Spring_Project.basic.order.OrderService;
import Spring_Project.basic.order.OrderServiceImpl;

public class AppConfig {

    // AppConfig는 앱의 실제 동작에 필요한 구현 객체를 생성

    // 생성자 주입
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
