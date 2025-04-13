package kr.co.khedu.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.country.model.dto.CountryDTO;
import kr.co.khedu.country.service.CountryServiceImpl;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.product.common.ProductPath;
import kr.co.khedu.product.model.dto.ProductFavoriteDTO;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductDetailPageController
 */
@WebServlet("/products/detail/*")
public class ProductDetailPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// System.out.println(request.getPathInfo());
		
		// URL 경로에서 상품 아이디 추출
		String pathInfo = request.getPathInfo();

		int productId = ProductPath.getProductId(request, pathInfo);
		
		// 추출한 상품 아이디로 상품 조회
		Product product = new ProductServiceImpl().selectProductByProductId(productId);
		
		// 추출한 상품 아이디로 리뷰 평점 조회
		double reviewScore = new ProductServiceImpl().selectProductReview(productId);
		
		// 추출한 상품 아이디로 리뷰 작성한 회원 조회
//		List<ProductReviewDTO> productReviewMemberList = new ProductServiceImpl().selectProductReviewMemberList(productId);
//		
//		for(ProductReviewDTO pr : productReviewMemberList) {
//			System.out.println("pr : " + pr);
//		}
		
		if(product == null) {
			// TODO: 에러 페이지로 이동
			System.out.println("상품 상세 페이지 오류입니다.");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		System.out.println(product);
		

		// 국가 정보 가져오기
		List<? extends CountryDTO> countryList = new CountryServiceImpl().selectCountryList();
		String countryName = "Unknown";
		
		for(CountryDTO c : countryList) {
			if(product.getCountryId() == c.getCountryId()) {
				countryName = c.getName();
				break;
			}
		}
		
		// 해당 상품을 찜 했는지 데이터 가져오기
		Member member = (Member) request.getSession().getAttribute("loginMember");
		int memberId = member.getMemberId();
		
		ProductFavoriteDTO productFavoriteInfo = new ProductServiceImpl().selectProductFavoriteChecked(new ProductFavoriteDTO(productId, memberId));
		
		request.setAttribute("productInfo", product);
		request.setAttribute("reviewScore", reviewScore);
		request.setAttribute("countryName", countryName);
		request.setAttribute("productFavoriteInfo", productFavoriteInfo);
//		request.setAttribute("productReviewMemberList", productReviewMemberList);
//		request.setAttribute("defaultPath", defaultPath);
		request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
