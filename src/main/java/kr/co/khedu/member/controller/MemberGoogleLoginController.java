package kr.co.khedu.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.key.KeyManager;

/**
 * Servlet implementation class MemberGoogleLoginController
 */
@WebServlet("/google-login")
public class MemberGoogleLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String clientId = KeyManager.get("google.clientId"); 
    private final String clientSecret = KeyManager.get("google.clientSecret"); 
    private final String redirectUri = KeyManager.get("google.redirectUrl");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberGoogleLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
