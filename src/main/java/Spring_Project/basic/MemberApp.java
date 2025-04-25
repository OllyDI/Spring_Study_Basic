package Spring_Project.basic;

import Spring_Project.basic.member.Grade;
import Spring_Project.basic.member.Member;
import Spring_Project.basic.member.MemberService;
import Spring_Project.basic.member.MemberServiceImpl;

public class MemberApp {
    // 순수 자바 개발로 테스트 -> 한계가 있음 그래서 JUnit 사용 -> test 패키지에서 검증
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
