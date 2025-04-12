package kr.co.khedu.common;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebFilter({"/*"})
public class AccessFilter implements Filter{

	// 접근 허용할 url들
	private static final List<String> EXCLUDED_URLS = 
			Arrays.asList("/trip-log/", "/trip-log/members/sign-in","/trip-log/members/sign-up",
					"/trip-log/products", "/trip-log/auth/sign-in", "/trip-log/google-login/callback?");
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		// 정적 리소스 예외처리
		if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png")
                || uri.endsWith(".jpg") || uri.endsWith(".ttf")) {
            chain.doFilter(request, response);
            return;
        }

		
		HttpSession session = req.getSession(false);
		
		// 로그인 없이 접근 가능한 uri인지 확인
		//boolean isLoggedIn = session != null && session.getAttribute("loginMember") != null;
		boolean isExcluded = EXCLUDED_URLS.stream().anyMatch(uri::equals);

		System.out.println("--------------------1");
		if(isExcluded) {
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println("--------------------2");
		if (session == null || session.getAttribute("loginMember") == null) {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			
			
			out.println("<html> <head>");
			out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
			out.println("</head> <body>");
			
			out.println("<script>");
			//out.println("Swal.fire(\"로그인 후 이용해 주세요\");");
			out.println("Swal.fire({\r\n"
					+ "  title: \"로그인 후 이용 가능합니다.\",\r\n"
					+ "  icon: \"warning\"\r\n"
					+ "}).then(() => { location.href = '" + req.getContextPath() + "/members/sign-in'; });");
			out.println("</script>");
			
			out.println("</body> </html>");
			out.close();
			
			//res.sendRedirect(req.getContextPath() + "/members/sign-in");
		} else {
			chain.doFilter(request, response);
		}
		// 로그인 없이 접근 가능한 uri
//		if(uri.equals("/members/sign-in") ||
//				uri.equals("members/sign-up") ||
//				uri.equals("/products/")
//				) {
//			chain.doFilter(request, response);
//			return;
//		}
//		
		// 로그인 되어있어야 접근 가능
		// 로그인 안 되어있으면 alert 표시 후 로그인 페이지로 이동
//		if(session.getAttribute("loginMember") == null) {
//			res.sendRedirect(req.getContextPath());
//		} else {
//			chain.doFilter(request, response);
//		}
	}
}
