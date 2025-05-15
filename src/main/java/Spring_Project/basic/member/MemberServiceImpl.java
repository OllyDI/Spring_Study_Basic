package Spring_Project.basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 이런식으로 구현하면 개방 폐쇄, 의존성 역전 원칙 어긋남
    private final MemberRepository memberRepository;

    // 자동 의존관계 주입
    @Autowired  // ac.bean(MemeberRepository.class)랑 같은 의미
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long memberId) {
        return memberRepository.findById(memberId);
    }
    
    
    // 테스트용 메서드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

