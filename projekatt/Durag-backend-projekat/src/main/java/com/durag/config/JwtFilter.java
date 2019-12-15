package com.durag.config;
 

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


/**JWT Filter
 * re-implementacija Genetickog Filtera, metoda <i>doFilter()<i>
 * */
public class JwtFilter extends GenericFilterBean {
	
	@Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization"); //autorizacija iz request-a

        	//1. req sa OPTIONS
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);  // poziva sledeci filter u lanacu
        } else {

        	//provera token autorizacije
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            final String token = authHeader.substring(7); //auth token

            try {
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);  //postavljanje 'calmiva' u request
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token.");
            }

            chain.doFilter(req, res);
        }

    }
}
