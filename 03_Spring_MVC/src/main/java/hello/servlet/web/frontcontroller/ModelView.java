package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kangmoo Heo
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ModelView {
    @NonNull
    private String viewName;
    private Map<String, Object> model = new ConcurrentHashMap<>();
}
