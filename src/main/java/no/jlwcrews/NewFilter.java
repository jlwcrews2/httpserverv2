package no.jlwcrews;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NewFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(NewFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        logger.info("Request {} {}", req.getMethod(), req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
