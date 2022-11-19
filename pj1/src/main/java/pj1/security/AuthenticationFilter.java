package pj1.security;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pj1.vo.RequestVo;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
   throws AuthenticationException {
	   try {
		   RequestVo creds = new ObjectMapper().readValue(request.getInputStream(),RequestVo.class);
		   
		   return getAuthenticationManager().authenticate(
				   new UsernamePasswordAuthenticationToken(
						 creds.getMemEmail(),
						 creds.getMemPw(),
						 new ArrayList<>()
						   )
				   );
	   }catch (Exception e) {
		   throw new RuntimeException(e);
	   }
	   
   }
   
   @Override
   protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,FilterChain chain,
		   Authentication authResult) throws IOException, ServletException {
	   
	   log.debug(((User)authResult.getPrincipal()).getUsername());
	   
   }

}