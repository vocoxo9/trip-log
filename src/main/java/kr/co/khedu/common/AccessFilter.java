package kr.co.khedu.common;

import java.io.IOException;

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

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		
		// 로그인 없이 접근 가능한 uri
		if(uri.contains("/members/sign-in") ||
				uri.contains("members/sign-up") ||
				uri.contains("/products") ||
				uri.contains("/resources/")
				) {
			chain.doFilter(request, response);
			return;
		}
		
		// 로그인 되어있으면 접근 가능
		if(session.getAttribute("loginMember") != null) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath());
		}
	}
}
