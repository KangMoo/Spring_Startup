package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kangmoo Heo
 */
public class MemberRepository {
    private Map<Long, Member> store = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong();

    private static final MemberRepository INSTANCE = new MemberRepository();

    private MemberRepository() { }

    public static MemberRepository getInstance() {
        return INSTANCE;
    }

    public Member save(Member member){
        member.setId(sequence.incrementAndGet());
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        this.store.clear();
    }

}
