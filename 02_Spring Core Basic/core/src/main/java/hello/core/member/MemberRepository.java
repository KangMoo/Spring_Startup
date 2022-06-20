package hello.core.member;

/**
 * @author kangmoo Heo
 */
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
