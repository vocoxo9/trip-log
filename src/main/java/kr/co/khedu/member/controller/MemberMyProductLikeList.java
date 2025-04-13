package kr.co.khedu.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.model.dto.MemberProductFavoriteDTO;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class MemberMyProductLikeList
 */
@WebServlet("/members/productLikes")
public class MemberMyProductLikeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyProductLikeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO loginMember = (MemberDTO)request.getSession().getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath());
		}
		int memberId = loginMember.getMemberId();
		
		// 내 상품 찜 정보 불러오기 - 성준
		List<MemberProductFavoriteDTO> myProductFavoriteList = new ProductServiceImpl().selectMyProductFavorite(memberId);
		
		// for(MemberProductFavoriteDTO mpf : myProductFavoriteList) System.out.println(mpf);
		
		request.setAttribute("myProductFavoriteList", myProductFavoriteList);
		
		// 여기까지
		
		request.getRequestDispatcher("/WEB-INF/views/member/myProductLikeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
