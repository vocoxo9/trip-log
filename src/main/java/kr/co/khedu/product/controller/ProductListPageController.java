package kr.co.khedu.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductListPageController
 */
@WebServlet("/products")
public class ProductListPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		System.out.println("keyword : " + keyword);
		
		int listCount = new ProductServiceImpl().selectByProductNameCount(keyword);
		System.out.println(listCount);
		
		// 최대 아이템 수와 페이지 수
		int itemLimit = 12;
		int pageLimit = 10;
		
		// 현재 페이지 번호
		int currentPageNo = request.getParameter("cpage") != null ? Integer.parseInt(request.getParameter("cpage")) : 1;
		
		PageInfo pageInfo = new PageInfo(listCount, currentPageNo, pageLimit, itemLimit);
		
		// 상품 조회 후 List Collection에 저장
//		List<Product> pList = new ProductServiceImpl().selectProductList();
		List<Product> pList = new ProductServiceImpl().selectByProductName(keyword, pageInfo);
		
//		for(Product p : pList) System.out.println(p);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("keyword", keyword);
		request.setAttribute("pList", pList);
		request.getRequestDispatcher("WEB-INF/views/product/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
