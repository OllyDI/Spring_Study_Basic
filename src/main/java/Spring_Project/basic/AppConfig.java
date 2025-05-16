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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    // AppConfig는 앱의 실제 동작에 필요한 구현 객체를 생성
    // 생성자 주입 -> Bean을 쓰게 되면 스프링 컨네이너에 등록, @Bean(name='')으로 바꿀 수 있지만 디폴트를 따르는게 좋음
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
