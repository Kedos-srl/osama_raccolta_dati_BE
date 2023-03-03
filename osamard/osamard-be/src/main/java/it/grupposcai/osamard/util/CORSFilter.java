package it.grupposcai.osamard.util;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends OncePerRequestFilter {


    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //if ("OPTIONS".equals(request.getMethod())) {
        // CORS "pre-flight" request
        response.addHeader("Access-Control-Max-Age", "86400");
        //}

        filterChain.doFilter(request, response);
    }


}
