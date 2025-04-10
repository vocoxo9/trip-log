package kr.co.khedu.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class TripFileUtils {
	public static String saveFile(Part p, HttpSession session, String path) {
		String originFileName = p.getSubmittedFileName();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int randomValue = (int)(Math.random() * 99999999) + 1;
		
		String changeFileName = "trip-log_" + currentDate + "_" + randomValue + ext;
		
		String savePath = session.getServletContext().getRealPath(path);
		
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		File f = new File(savePath, changeFileName); // 공부자료 보고 적용해보기
		
		return changeFileName;
	}
}
