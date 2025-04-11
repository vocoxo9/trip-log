package kr.co.khedu.product.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.co.khedu.common.TripFileUtils;
import kr.co.khedu.product.common.ProductPath;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductUpdateController
 */
@WebServlet("/products/auth/update")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,// 이 크기가 넘으면 디스크의 임시디렉터리에 저장됨 (기본값은 0 => 무조건 임시 디렉터리)
		maxFileSize = 1024 * 1024 * 10,		// 파일의 최대 크기 (기본값은 -1L => 제한이 없음)
		maxRequestSize = 1024 * 1024 * 15	// 한 요청의 최대 크기, 여러 파일 및 전송값 등을 합한 최대 크기 (기본값은 -1L => 제한 없음)
)
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateController() {
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
		System.out.println("상품 수정 !!!");
		TripFileUtils uploadUtil = TripFileUtils.create(request.getServletContext());
		String name = "";
		String originFileName = "";
		String changeFileName = "";
		int price = 0;
		int stock = 0;
		String description = "";
		
		Collection<Part> parts = request.getParts();
		
		parts.forEach(e -> System.out.println(e.getName()));
		
		Iterator<Part> i = parts.iterator();
		
		while(i.hasNext()) {
//			System.out.println(i.next().getName());
//			System.out.println(request.getParameter(i.next().getName()));
			Part p = i.next();
			String formTypeName = p.getName();

			switch (formTypeName) {
			    case "name":
			        name = request.getParameter(formTypeName);
			        break;
			    case "uploadFile":
			    	if(!p.getSubmittedFileName().equals("")) {
			    		String subFolder = uploadUtil.createFilePath(); // yyyy/MM/dd 폴더 경로
			    		// System.out.println(subFolder);
			    		changeFileName = TripFileUtils.changeFileName(p);
			    		// System.out.println(changeFileName);
			    		uploadUtil.saveFile(p, subFolder, changeFileName);
			    		changeFileName = "/assets/resources/upload/" + subFolder + "/" + changeFileName;
			    		
				    	originFileName = p.getSubmittedFileName();
			    	} else {
						// 상품 이미지가 없는 경우 샘플 이미지로 대체
						String sampleImgPath = ProductPath.sampleImg();
						originFileName = sampleImgPath.substring(sampleImgPath.lastIndexOf("/") + 1);
						changeFileName = sampleImgPath;
			    	}
			        break;
			    case "description":
			        description = request.getParameter(formTypeName);
			        break;
			    case "price":
			        price = Integer.parseInt(request.getParameter(formTypeName));
			        break;
			    case "stock":
			        stock = Integer.parseInt(request.getParameter(formTypeName));
			        break;
			}
		}
		
		Product product = new Product(name, price, stock, description, originFileName, changeFileName);
		System.out.println("update : " + product);
		
		int result = new ProductServiceImpl().updateProduct(product);
		
		 System.out.println("update : " + result);
		
		if(result > 0) {
			response.sendRedirect("/trip-log/products");
		} else {
			// 추후 수정 예정
			request.setAttribute("errorMsg", "로그인 정보가 잘못되었습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
