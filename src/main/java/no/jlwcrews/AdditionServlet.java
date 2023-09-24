package no.jlwcrews;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class AdditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        var additionRequest = new ObjectMapper().readValue(body, AdditionRequest.class);
        var additionResult = new AdditionResult(additionRequest.first() + additionRequest.second());
        resp.getWriter().write("Result is " + additionResult.result());
    }
}

record AdditionRequest(
        float first,
        float second
){}

record AdditionResult(
        float result
){}
