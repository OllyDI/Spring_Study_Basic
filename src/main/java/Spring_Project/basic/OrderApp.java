package Spring_Project.basic;

import Spring_Project.basic.member.Grade;
import Spring_Project.basic.member.Member;
import Spring_Project.basic.member.MemberService;
import Spring_Project.basic.member.MemberServiceImpl;
import Spring_Project.basic.order.Order;
import Spring_Project.basic.order.OrderService;
import Spring_Project.basic.order.OrderSeviceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderSeviceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
