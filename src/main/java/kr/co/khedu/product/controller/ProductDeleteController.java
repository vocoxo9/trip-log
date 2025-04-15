package kr.co.khedu.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductDeleteController
 */
@WebServlet("/products/auth/delete/*")
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 번호 추출하기
		String path = request.getPathInfo();
		// System.out.println(path.substring(1));
		int productId = Integer.parseInt(path.substring(1));
		// System.out.println("delete productId : " + productId);
		
		int result = new ProductServiceImpl().deleteProduct(productId);
		
		if(result > 0) {
			response.sendRedirect("/trip-log/products");
		} else {
			// 에러페이지 연동
			request.setAttribute("errorMsg", "상품 삭제에 실패했습니다.");
		    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
