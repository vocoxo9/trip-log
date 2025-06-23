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
		               "/trip-log/products", "/trip-log/auth/sign-in", "/trip-log/google-login/callback", "/trip-log/kakao-login", "/trip-log/members/email-check"  );

	
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
		boolean isExcluded = EXCLUDED_URLS.stream().anyMatch(uri::equals);
		
		if(isExcluded) {
			chain.doFilter(request, response);
			return;
		}
		
		if (session == null || session.getAttribute("loginMember") == null) {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			
			
			out.println("<html> <head>");
			out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
			out.println("</head> <body>");
			
			out.println("<script>");
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
	}
}
