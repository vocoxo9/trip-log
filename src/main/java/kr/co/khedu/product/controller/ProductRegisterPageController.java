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

/**
 * Servlet implementation class ProductRegisterPageController
 */
@WebServlet("/register")
public class ProductRegisterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegisterPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 국가 정보 가져오기
		List<? extends CountryDTO> countryList = new CountryServiceImpl().selectCountryList();
		
		for(CountryDTO c : countryList) System.out.println(c);
		
		if(countryList != null) {
			request.setAttribute("countryInfo", countryList);
			request.getRequestDispatcher("WEB-INF/views/product/productRegister.jsp").forward(request, response);
		} else {
			// 에러페이지 처리
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
