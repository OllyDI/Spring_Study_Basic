package Spring_Project.basic;

import Spring_Project.basic.member.*;
import Spring_Project.basic.order.Order;
import Spring_Project.basic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 15000);
        System.out.println("order = " + order);
    }
}
