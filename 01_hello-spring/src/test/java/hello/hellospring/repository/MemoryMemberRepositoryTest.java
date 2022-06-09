package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author kangmoo Heo
 */
public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository = new MemoryMemberRepository();
    }

    @Test
    public void save(){
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member1);
        repository.save(member2);

        Member result1 = repository.findById(member1.getId()).get();
        Member result2 = repository.findById(member2.getId()).get();

        Assertions.assertEquals(member1, result1);
        assertThat(member2).isEqualTo(result2);

        result2 = repository.findByName(result2.getName()).get();
        assertThat(member2).isEqualTo(result2);
    }
}

