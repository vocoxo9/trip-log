package kr.co.khedu.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductRegisterController
 */
@WebServlet("/products/auth/register")
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegisterController() {
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
		// System.out.println("test");
		request.setCharacterEncoding("UTF-8");
//		String name = request.getParameter("name");
//		String uploadFile = request.getParameter("uploadFile");
//		int stock = Integer.parseInt(request.getParameter("stock"));
//		int price = Integer.parseInt(request.getParameter("price"));
//		String description = request.getParameter("description");
		
		String name = "";
		String uploadFile = "/assets/upload/images/"; 
		int stock = 0;
		int price = 0;
		String description = "";
		
		try {
			
		} catch(Exception e) {
			
		}
		
		System.out.println(name);
		System.out.println(stock);
		System.out.println(price);
		System.out.println(description);
		System.out.println("파일 : "  + uploadFile);
		
		Product product = new Product(name, price, stock, description);
		System.out.println(product);
		
		int result = new ProductServiceImpl().insertProduct(product);
		
		System.out.println(result);
		
		if(result > 0) {
			response.sendRedirect("/trip-log/products");
		} else {
			// 추후 수정 예정
			request.setAttribute("errorMsg", "로그인 정보가 잘못되었습니다");
			 request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}
		
}
