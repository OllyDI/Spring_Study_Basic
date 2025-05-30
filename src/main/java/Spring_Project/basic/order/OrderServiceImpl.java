package Spring_Project.basic.order;

import Spring_Project.basic.annotation.MainDiscountPolicy;
import Spring_Project.basic.discount.DiscountPolicy;
import Spring_Project.basic.member.Member;
import Spring_Project.basic.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor    // final이 붙은 변수를 가지고 생성자를 자동 생성
public class OrderServiceImpl implements OrderService {

    /*
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    위의 방식대로 구현하면 문제점
    1. OrderServiceImpl 클래스가 DiscountPolicy 인터페이스 뿐 아니라 FixDiscount or RateDiscount 구체 클래스도 의존함
    2. 할인 정책을 변경하려면 클라이언트 코드를 변경해야 함
    -> OCP, DIP 원칙 벗어남 그래서 AppConfig 클래스를 통해 구체 클래스를 구현함
     */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired 생성자가 하나면 생략 가능
//    @RequiredArgsConstructor 가 알아서 생성자를 만들어줘서 필요 없음
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    
    // 테스트용 메서드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
