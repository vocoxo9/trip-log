package kr.co.khedu.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
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

		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword") != null ? request.getParameter("keyword") : "";
		String sort = request.getParameter("sort") != null ? request.getParameter("sort") : "";
//		System.out.println("keyword : " + keyword);
//		System.out.println("sort : " + sort);
		ProductSearchDTO productSearchDTO = new ProductSearchDTO(keyword, sort);

		
		int listCount = new ProductServiceImpl().selectByProductNameCount(productSearchDTO);
//		System.out.println(listCount);
		
		// 최대 아이템 수와 페이지 수
		int itemLimit = 12;
		int pageLimit = 10;
		
		// 현재 페이지 번호
		int currentPageNo = request.getParameter("cpage") != null ? Integer.parseInt(request.getParameter("cpage")) : 1;
		
		PageInfo pageInfo = new PageInfo(listCount, currentPageNo, pageLimit, itemLimit);
		
		// 상품 조회 후 List Collection에 저장
//		List<Product> pList = new ProductServiceImpl().selectProductList();
//		List<Product> pList = new ProductServiceImpl().selectByProductName(productSearchDTO, pageInfo);
		List<ProductListDTO> pList = new ProductServiceImpl().selectByProductName(productSearchDTO, pageInfo);
		
		for(ProductListDTO p : pList) System.out.println(p);
		
//		System.out.println(productSearchDTO.getKeyword());
//		System.out.println(productSearchDTO.getSort());
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("sort", productSearchDTO.getSort());
		request.setAttribute("keyword", productSearchDTO.getKeyword());
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
