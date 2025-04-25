package Spring_Project.basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository  implements MemberRepository {

    // 원래는 ConcurrentHashMap을 사용하여 동시접근 에러를 잡아야함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
