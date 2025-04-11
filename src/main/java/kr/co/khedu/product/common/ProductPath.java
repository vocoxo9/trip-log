package kr.co.khedu.product.common;

import javax.servlet.http.HttpServletRequest;

public class ProductPath {
	public static int getProductId(HttpServletRequest request, String pathInfo) {
		String path = "";
		
		if(pathInfo == null || pathInfo.equals("/")) {
			String uri = request.getRequestURI(); // 웹 서버로 요청 시, 요청에 사용된 URL 로부터 URI 값을 리턴
			path = uri.substring(uri.lastIndexOf("/") + 1);
		} else {
			path = pathInfo.substring(1);
		}
		
		// 숫자인지 확인 후 변환
		int productId = 0;
		
		if(path.matches("\\d+")) {
			productId = Integer.parseInt(path);
		} else {
			// TODO: 에러 페이지 이동
			System.out.println("오류입니다.");
		}
		
		System.out.println(productId);
		return productId;
	}
}
