package Spring_Project.basic;

import Spring_Project.basic.member.*;

public class MemberApp {
    // 순수 자바 개발로 테스트 -> 한계가 있음 그래서 JUnit 사용 -> test 패키지에서 검증
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
