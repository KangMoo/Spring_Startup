package hello.core.member;

/**
 * @author kangmoo Heo
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memeberId);
}
