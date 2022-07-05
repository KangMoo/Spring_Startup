package hello.core.common;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * @author kangmoo Heo
 */
@Component
@Scope(value = "request")
@Setter
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void log(String message) {
        System.out.printf("[%s] [%s] %s%n", uuid, requestURL, message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.printf("[%s] request scope bean create: %s%n", uuid, this);
    }

    @PreDestroy
    public void close(){
        System.out.printf("[%s] request scope bean close: %s%n", uuid, this);
    }

}
