package Spring_Project.basic.member;

public interface MemberService {

    void join(Member member);

    Member findMember(long memberId);
}
