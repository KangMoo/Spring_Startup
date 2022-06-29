package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * @author kangmoo Heo
 */
public class AutoWiredTest {
    @Test
    void AutoWiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required =  false)
        public void setNoBean1(Member noBean){
            System.out.println("noBean1 = " + noBean);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean){
            System.out.println("noBean2 = " + noBean);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean){
            System.out.println("noBean3 = " + noBean);
        }

    }
}
