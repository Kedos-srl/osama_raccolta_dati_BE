package it.grupposcai.osamard.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
        response.addHeader("Access-Control-Allow-Origin", "*");

        if (request.getMethod().equals("OPTIONS")) {
            response.addHeader("Access-Control-Max-Age", "86400");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }


        filterChain.doFilter(request, response);
    }

}