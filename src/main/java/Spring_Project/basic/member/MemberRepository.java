package Spring_Project.basic.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);

}

