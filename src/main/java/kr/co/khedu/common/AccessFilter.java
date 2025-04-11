package kr.co.khedu.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/trip-log/*"})
public class AccessFilter implements Filter{

	// 접근 허용할 url들
	private static final List<String> EXCLUDED_URLS = 
			Arrays.asList("/trip-log/", "/trip-log/members/sign-in","/trip-log/members/sign-up",
					"/trip-log/products" );
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		
		//boolean isLoggedIn = session != null && session.getAttribute("loginMember") != null;
		
		
		// 로그인 없이 접근 가능한 uri
		if(uri.equals("/members/sign-in") ||
				uri.equals("members/sign-up") ||
				uri.equals("/products/")
				) {
			chain.doFilter(request, response);
			return;
		}
		
		// 로그인 되어있어야 접근 가능
		// 로그인 안 되어있으면 alert 표시 후 로그인 페이지로 이동
		if(session.getAttribute("loginMember") != null) {
			chain.doFilter(request, response);
		} else {
			
			res.sendRedirect(req.getContextPath() + "/members/sign-in");
		}
	}
}
