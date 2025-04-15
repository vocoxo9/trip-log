package kr.co.khedu.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.product.model.dto.ProductFavoriteDTO;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductFavoriteDeleteController
 */
@WebServlet("/products/auth/delete/favorite")
public class ProductFavoriteDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFavoriteDeleteController() {
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
		request.setCharacterEncoding("UTF-8");
		int productId = Integer.parseInt(request.getParameter("productId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		
		System.out.println("상품 찜 취소");
		System.out.println("productId : " + productId);
		System.out.println("memberId : " + memberId);
		
		int result = new ProductServiceImpl().deleteProductFavoirte(new ProductFavoriteDTO(productId, memberId));
		
		if(result > 0) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("title", "상품 찜 취소");
			jsonObj.put("icon", "success");
			jsonObj.put("text", "상품 찜 취소 성공");
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(jsonObj);
		}
	}

}
