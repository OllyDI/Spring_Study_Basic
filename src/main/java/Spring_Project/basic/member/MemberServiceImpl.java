package Spring_Project.basic.member;

public class MemberServiceImpl implements MemberService {

    // 이런식으로 구현하면 개방 폐쇄, 의존성 역전 원칙 어긋남
    private final MemberRepository memberRepository;

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
}

