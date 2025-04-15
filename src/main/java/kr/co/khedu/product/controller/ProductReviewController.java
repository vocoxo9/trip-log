package kr.co.khedu.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.product.common.ProductPath;
import kr.co.khedu.product.model.vo.Review;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductReviewController
 */
@WebServlet("/products/review/*")
public class ProductReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReviewController() {
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
		String pathInfo = request.getPathInfo();
		int productId = ProductPath.getProductId(request, pathInfo);
		double score = Double.parseDouble(request.getParameter("score"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		
		// System.out.println(score);
		// System.out.println(productId);
		System.out.println(memberId);
		
		int result = new ProductServiceImpl().insertProductReview(new Review(score, memberId, productId));
		
		if(result > 0) {
			// JSON 객체로 만들어서 응답
			JSONObject jsonObj = new JSONObject(); // {}
			jsonObj.put("title", "리뷰 등록");
			jsonObj.put("icon", "success");
			jsonObj.put("text", "리뷰 등록 성공");
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(jsonObj);
		}
	}

}
