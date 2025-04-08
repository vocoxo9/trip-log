package kr.co.khedu.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberKakaoLoginController
 */
@WebServlet("/trip-log/kakao-login")
public class MemberKakaoLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String clientId = "959ef6d54b0b5fdcc19392ec224bed96"; 
    private String clientSecret = "HkF08DInrPVJSzswOqell1AqVWytllj9"; 
    private String redirectUri = "https://localhost:8080/trip-log/kakao-login";
    
    public MemberKakaoLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
        
    }

}
