package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kangmoo Heo
 */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //Content-Type: application/json

        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setAge(20);
        data.setUsername("Kim");

        String result = objectMapper.writeValueAsString(data);
        res.getWriter().write(result);

    }
}
